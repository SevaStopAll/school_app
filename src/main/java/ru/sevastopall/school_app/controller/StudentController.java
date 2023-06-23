package ru.sevastopall.school_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.school_app.domain.*;
import ru.sevastopall.school_app.service.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

@Controller
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private HomeworkService homeworks;
    private MarkService marks;
    private StudentService students;
    private UserService users;

    @GetMapping("/{id}")
    public String getInfo(Model model, @PathVariable int id) {
        var studentOptional = students.findByUser(users.findById(id).get());
        if (studentOptional.isEmpty()) {
            model.addAttribute("message", "Нет студента с указанным идентификатором");
            return "errors/404";
        }
        Student student = studentOptional.get();
        model.addAttribute("marks", marks.findByStudent(student));
        model.addAttribute("homeworks", homeworks.findBySchoolClass(student.getSchoolClass()));
        return "student/one";
    }

    @GetMapping("/file/{id}")
    public ResponseEntity<byte[]> getInfo(@PathVariable int id) throws IOException {
        var studentOptional = students.findByUser(users.findById(id).get());
        Student student = studentOptional.get();
        try (FileWriter out = new FileWriter("./src/main/resources/data/report.txt")) {
            out.append("Оценки");
            out.append(System.lineSeparator());
            out.append("Оценка");
            out.append(" ");
            out.append("Предмет");
            out.append(" ");
            out.append("Ученик");
            out.append(System.lineSeparator());
            for (Mark mark : marks.findByStudent(student)) {
                out.append(String.valueOf(mark.getScore().getId()));
                out.append(mark.getSubject().getName());
                out.append(mark.getStudent().getLastName());
                out.append(System.lineSeparator());
            }
            out.append(System.lineSeparator());
            out.append(System.lineSeparator());
            out.append("Домашнее задание");
            out.append(System.lineSeparator());
            out.append("Предмет");
            out.append(" ");
            out.append("Описание");
            out.append(" ");
            for (Homework homework : homeworks.findBySchoolClass(student.getSchoolClass())) {
                out.append(homework.getSubject().getName());
                out.append(homework.getDescription());
                out.append(System.lineSeparator());
            }

            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
        var content = Files.readAllBytes(Path.of("./src/main/resources/data/report.txt"));
        HttpHeaders headers = new HttpHeaders();
        String filename = "Report.txt";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        headers.setContentType(MediaType.parseMediaType("application/txt"));
        return new ResponseEntity<>(content,headers, HttpStatus.OK);
    }

}
