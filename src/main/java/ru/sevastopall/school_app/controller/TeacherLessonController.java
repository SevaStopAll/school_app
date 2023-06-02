package ru.sevastopall.school_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sevastopall.school_app.domain.*;
import ru.sevastopall.school_app.service.*;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class TeacherLessonController {

    private TeacherService teachers;
    private SchoolClassService classes;
    private SubjectService subjects;
    private LessonService lessons;

    @GetMapping("/teachers/create")
    public String getTeachersCreationPage(Model model) {
        return "admin/teachers/create";
    }

    @PostMapping("/teachers/create")
    public String saveTeacher(@ModelAttribute Teacher teacher) {
        teachers.save(teacher);
        return "redirect:/index";
    }

    @GetMapping("/teachers/list")
    public String getTeachers(Model model) {
        model.addAttribute("teachers", teachers.findAll());
        return "admin/teachers/list";
    }

    @GetMapping("/subjects/create")
    public String getSubjectCreationPage(Model model) {
        model.addAttribute("teachers", teachers.findAll());
        return "admin/subjects/create";
    }

   @PostMapping("/subjects/create")
    public String saveSubject(@ModelAttribute Subject subject, String[] teachersIds) {
       Set<Teacher> teacherSet = new HashSet<>();
       for (String id : teachersIds) {
           teacherSet.add(teachers.findById(Integer.parseInt(id)).get());
       }
       subject.setTeachers(teacherSet);
       subjects.save(subject);
       return "redirect:/";
    }

    @GetMapping("/subjects/list")
    public String getSubjects(Model model) {
        model.addAttribute("subjects", subjects.findAll());
        return "admin/subjects/list";
    }

    @GetMapping("/lessons/create")
    public String getLessonCreationPage(Model model) {
        model.addAttribute("classes", classes.findAll());
        model.addAttribute("teachers", teachers.findAll());
        model.addAttribute("subjects", subjects.findAll());
        return "admin/lessons/create";
    }

    @PostMapping("/lessons/create")
    public String saveLesson(@ModelAttribute Lesson lesson, String number) {
        lesson.setNumber(Integer.parseInt(number));
        lessons.save(lesson);
        return "redirect:/";
    }

    @GetMapping("/lessons/list")
    public String getLessons(Model model) {
        model.addAttribute("lessons", lessons.findAll());
        return "admin/lessons/list";
    }


}
