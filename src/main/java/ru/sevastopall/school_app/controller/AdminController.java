package ru.sevastopall.school_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sevastopall.school_app.domain.*;
import ru.sevastopall.school_app.service.*;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private TeacherService teachers;
    private SchoolClassService classes;
    private SubjectService subjects;
    private StudentService students;

    private LessonService lessons;

    @GetMapping("/teachers/create")
    public String getTeachersCreationPage(Model model) {
        return "admin/teachers/create";
    }

    @PostMapping("/teachers/create")
    public String create(@ModelAttribute Teacher teacher, Model model) {
        teachers.save(teacher);
        return "redirect:/index";
    }

    @GetMapping("/subjects/create")
    public String getSubjectCreationPage(Model model) {
        model.addAttribute("teachers", teachers.findAll());
        return "admin/subjects/create";
    }

   @PostMapping("/subjects/create")
    public String save(@ModelAttribute Subject subject) {
       subjects.save(subject);
       return "redirect:/index";
    }

    @GetMapping("/classes/create")
    public String getClassCreationPage(Model model) {
        return "admin/classes/create";
    }

    @PostMapping("/subjects/create")
    public String save(@ModelAttribute SchoolClass schoolclass) {
        classes.save(schoolclass);
        return "redirect:/index";
    }

    @GetMapping("/students/create")
    public String getStudentCreationPage(Model model) {
        model.addAttribute("classes", classes.findAll());
        return "admin/students/create";
    }

    @PostMapping("/students/create")
    public String save(@ModelAttribute Student student) {
        students.save(student);
        return "redirect:/index";
    }

    @GetMapping("/lessons/create")
    public String getLessonCreationPage(Model model) {
        model.addAttribute("classes", classes.findAll());
        model.addAttribute("teachers", teachers.findAll());
        model.addAttribute("subjects", subjects.findAll());
        return "admin/lessons/create";
    }

    @PostMapping("/lessons/create")
    public String save(@ModelAttribute Lesson lesson) {
        lessons.save(lesson);
        return "redirect:/index";
    }

}
