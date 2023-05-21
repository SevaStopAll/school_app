package ru.sevastopall.school_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.school_app.domain.SchoolClass;
import ru.sevastopall.school_app.domain.Student;
import ru.sevastopall.school_app.service.HomeworkService;
import ru.sevastopall.school_app.service.MarkService;

@Controller
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
    private HomeworkService homeworks;
    private MarkService marks;

    @GetMapping("/homework/all")
    public String getHomework(Model model) {
        model.addAttribute("homework", homeworks.findBySchoolClass(new SchoolClass()));
        return "student/homework/all";
    }

    @GetMapping("/marks/all")
    public String getMarks(Model model) {
        model.addAttribute("classes", marks.findByStudent(new Student()));
        return "student/marks/all";
    }

}
