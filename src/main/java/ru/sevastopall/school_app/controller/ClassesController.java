package ru.sevastopall.school_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sevastopall.school_app.domain.*;
import ru.sevastopall.school_app.service.MarkService;
import ru.sevastopall.school_app.service.SchoolClassService;
import ru.sevastopall.school_app.service.StudentService;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class ClassesController {
    private SchoolClassService classes;
    private StudentService students;

    private MarkService marks;

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

    @GetMapping("/students/{id}")
    public String getOneStudent(Model model, @PathVariable int id) {
        var studentOptional = students.findById(id);
        if (studentOptional.isEmpty()) {
            model.addAttribute("message", "Ученика не найдено");
            return "errors/404";
        }
        Student student = studentOptional.get();
        model.addAttribute("student", student);
        List<Mark> studentMarks = marks.findByStudentId(student.getId());
        studentMarks.stream().map(mark -> mark.getSubject().getName()).collect(Collectors.toList());
        model.addAttribute("marks", studentMarks);
        model.addAttribute("demo", marks.getResults(student));
        model.addAttribute("avgMark", studentMarks.stream().mapToInt(m -> m.getScore().getDescription()).average().orElse(0));
        return "admin/students/one";
    }

}
