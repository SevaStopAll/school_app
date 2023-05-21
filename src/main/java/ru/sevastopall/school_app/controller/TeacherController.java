package ru.sevastopall.school_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.school_app.service.*;

@Controller
@RequestMapping("/teacher")
@AllArgsConstructor
public class TeacherController {
    private TeacherService teachers;
    private SchoolClassService classes;

    private SubjectService subjects;

    private MarkService marks;
    private ScoreService score;

    private StudentService students;


    @GetMapping("/homework/create")
    public String getHomeworkCreationPage(Model model) {
        model.addAttribute("classes", classes.findAll());
        model.addAttribute("teachers", teachers.findAll());
        model.addAttribute("subjects", subjects.findAll());
        return "teacher/homework/create";
    }

/*    @PostMapping("/subjects/create")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        accidents.create(accident, ids);
        return "redirect:/index";
    }*/

    @GetMapping("/mark/create")
    public String getMarkCreationPage(Model model) {
        model.addAttribute("students", students.findAll());
        model.addAttribute("subjects", subjects.findAll());
        model.addAttribute("score", score.findAll());
        return "teacher/mark/create";
    }

/*    @PostMapping("/subjects/create")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        accidents.create(accident, ids);
        return "redirect:/index";
    }*/
}
