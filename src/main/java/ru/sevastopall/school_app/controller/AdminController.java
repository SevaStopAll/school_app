package ru.sevastopall.school_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sevastopall.school_app.service.SchoolClassService;
import ru.sevastopall.school_app.service.SubjectService;
import ru.sevastopall.school_app.service.TeacherService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {

    private TeacherService teachers;
    private SchoolClassService classes;

    private SubjectService subjects;

    @GetMapping("/teachers/create")
    public String getTeachersCreationPage(Model model) {
        return "admin/teachers/create";
    }

/*    @PostMapping("/teachers/create")
    public String create(@ModelAttribute Vacancy vacancy, @RequestParam MultipartFile file, Model model) {
        try {
            vacancyService.save(vacancy, new FileDto(file.getOriginalFilename(), file.getBytes()));
            return "redirect:/vacancies";
        } catch (Exception exception) {
            model.addAttribute("message", exception.getMessage());
            return "errors/404";
        }
    }*/

    @GetMapping("/subjects/create")
    public String getSubjectCreationPage(Model model) {
        model.addAttribute("teachers", teachers.findAll());
        return "admin/subjects/create";
    }

/*    @PostMapping("/subjects/create")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        accidents.create(accident, ids);
        return "redirect:/index";
    }*/

    @GetMapping("/classes/create")
    public String getClassCreationPage(Model model) {
        return "admin/classes/create";
    }

/*    @PostMapping("/subjects/create")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        accidents.create(accident, ids);
        return "redirect:/index";
    }*/

    @GetMapping("/students/create")
    public String getStudentCreationPage(Model model) {
        model.addAttribute("classes", classes.findAll());
        return "admin/students/create";
    }

/*    @PostMapping("/subjects/create")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        accidents.create(accident, ids);
        return "redirect:/index";
    }*/

    @GetMapping("/lessons/create")
    public String getLessonCreationPage(Model model) {
        model.addAttribute("classes", classes.findAll());
        model.addAttribute("teachers", teachers.findAll());
        model.addAttribute("subjects", subjects.findAll());
        return "admin/lessons/create";
    }

/*    @PostMapping("/subjects/create")
    public String save(@ModelAttribute Accident accident, HttpServletRequest req) {
        String[] ids = req.getParameterValues("rIds");
        accidents.create(accident, ids);
        return "redirect:/index";
    }*/

}
