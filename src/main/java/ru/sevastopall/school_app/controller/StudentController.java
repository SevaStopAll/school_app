package ru.sevastopall.school_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.school_app.domain.Homework;
import ru.sevastopall.school_app.domain.SchoolClass;
import ru.sevastopall.school_app.domain.Student;
import ru.sevastopall.school_app.service.HomeworkService;
import ru.sevastopall.school_app.service.MarkService;
import ru.sevastopall.school_app.service.SchoolClassService;
import ru.sevastopall.school_app.service.StudentService;

@Controller
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private HomeworkService homeworks;
    private MarkService marks;
    private SchoolClassService classes;

    @GetMapping("/homework")
    public String getHomework(Model model) {
        SchoolClass schoolClass = classes.findById(1).get();
        model.addAttribute("homeworks", homeworks.findBySchoolClass(schoolClass));
        return "student/homework";
    }

    @GetMapping("/marks")
    public String getMarks(Model model) {
        model.addAttribute("marks", marks.findByStudentId(1));
        return "student/marks";
    }

}
