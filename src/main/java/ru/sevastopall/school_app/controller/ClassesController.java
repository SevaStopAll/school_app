package ru.sevastopall.school_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.school_app.domain.SchoolClass;
import ru.sevastopall.school_app.domain.Student;
import ru.sevastopall.school_app.service.SchoolClassService;
import ru.sevastopall.school_app.service.StudentService;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class ClassesController {
    private SchoolClassService classes;
    private StudentService students;

    @GetMapping("/classes/create")
    public String getClassCreationPage() {
        return "admin/classes/create";
    }

    @PostMapping("/classes/create")
    public String saveClass(@ModelAttribute SchoolClass schoolclass) {
        classes.save(schoolclass);
        return "redirect:/";
    }

    @GetMapping("/classes/list")
    public String getClasses(Model model) {
        model.addAttribute("classes", classes.findAll());
        return "admin/classes/list";
    }

    @GetMapping("/students/create")
    public String getStudentCreationPage(Model model) {
        model.addAttribute("classes", classes.findAll());
        return "admin/students/create";
    }

    @PostMapping("/students/create")
    public String saveStudent(@ModelAttribute Student student, String classId) {
        student.setSchoolClass(classes.findById(Integer.parseInt(classId)).get());
        students.save(student);
        return "redirect:/";
    }

    @GetMapping("/students/list")
    public String getStudents(Model model) {
        model.addAttribute("students", students.findAll());
        return "admin/students/list";
    }

}
