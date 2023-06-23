package ru.sevastopall.school_app.controller;

import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import ru.sevastopall.school_app.utils.ReportSender;
import ru.sevastopall.school_app.utils.XLSXReportMaker;

import java.io.FileOutputStream;
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

    private XLSXReportMaker maker;

    private ReportSender sender;

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
    public ResponseEntity<byte[]> getInfo(@PathVariable int id) {
        maker.makeStudentReport(id);
        return sender.sendReport();
    }

}
