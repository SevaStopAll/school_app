package ru.sevastopall.school_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sevastopall.school_app.domain.Homework;
import ru.sevastopall.school_app.domain.Mark;
import ru.sevastopall.school_app.domain.Student;
import ru.sevastopall.school_app.domain.Teacher;
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
    private HomeworkService homeworks;
    private LessonService lessons;
    private UserService users;


    @GetMapping("/homework/create")
    public String getHomeworkCreationPage(Model model) {
        model.addAttribute("classes", classes.findAll());
        model.addAttribute("teachers", teachers.findAll());
        model.addAttribute("lessons", lessons.findAll());
        model.addAttribute("subjects", subjects.findAll());
        return "teacher/homework/create";
    }

   @PostMapping("/homework/create")
    public String save(@ModelAttribute Homework homework) {
        homeworks.add(homework);
        return "redirect:/";
    }

    @GetMapping("/mark/create")
    public String getMarkCreationPage(Model model) {
        model.addAttribute("students", students.findAll());
        model.addAttribute("subjects", subjects.findAll());
        model.addAttribute("scores", score.findAll());
        model.addAttribute("teachers", teachers.findAll());
        return "teacher/mark/create";
    }

    @PostMapping("/mark/new")
    public String saveMark(@ModelAttribute Mark mark, String student, String subject, String teacher, String scoreId) {
        mark.setScore(score.findById(Integer.parseInt(scoreId)).get());
        mark.setStudent(students.findById(Integer.parseInt(student)).get());
        mark.setTeacher(teachers.findById(Integer.parseInt(teacher)).get());
        mark.setSubject(subjects.findById(Integer.parseInt(subject)).get());
        marks.save(mark);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getInfo(Model model, @PathVariable int id) {
        var teacherOptional = teachers.findByUser(users.findById(id).get());
        if (teacherOptional.isEmpty()) {
            model.addAttribute("message", "Нет студента с указанным идентификатором");
            return "errors/404";
        }
        Teacher teacher = teacherOptional.get();
        model.addAttribute("marks", marks.findByTeacher(teacher));
        model.addAttribute("homeworks", homeworks.findByTeacher(teacher));
        return "teacher/one";
    }
}
