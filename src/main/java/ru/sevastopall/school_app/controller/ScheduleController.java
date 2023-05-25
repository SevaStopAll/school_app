package ru.sevastopall.school_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.school_app.domain.ClassDay;
import ru.sevastopall.school_app.domain.SchoolDay;
import ru.sevastopall.school_app.service.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class ScheduleController {
    private SchoolClassService classes;
    private LessonService lessons;
    private SchoolDayService days;
    private ClassDayService classDays;

    @GetMapping("/schedule/day/create")
    public String getDayCreationPage(Model model) {
        return "admin//schedule/day/create";
    }

    @PostMapping("/schedule/day/create")
    public String saveSchoolDay(@ModelAttribute SchoolDay schoolDay) {
        days.save(schoolDay);
        return "redirect:/";
    }

    @GetMapping("/schedule/day/list")
    public String getSchoolDays(Model model) {
        model.addAttribute("schoolDays", days.findAll());
        return "admin/schedule/day/list";
    }

    @GetMapping("/schedule/class/create")
    public String getClassDayCreationPage(Model model) {
        model.addAttribute("schoolDays", days.findAll());
        model.addAttribute("schoolClasses", classes.findAll());
        model.addAttribute("lessons", lessons.findAll());
        return "admin/schedule/class/create";
    }

    @PostMapping("/schedule/class/create")
    public String saveClassDay(@ModelAttribute ClassDay classday, String lesson1,
                               String lesson2, String lesson3) {
        classday.setLessons(List.of(lessons.findById(Integer.parseInt(lesson1)).get(),
                lessons.findById(Integer.parseInt(lesson2)).get(),
                lessons.findById(Integer.parseInt(lesson3)).get()));
        classDays.save(classday);
        return "redirect:/";
    }

    @GetMapping("/schedule/class/list")
    public String getClassDays(Model model) {
        model.addAttribute("classDays", classDays.findAll());
        return "admin/schedule/class/list";
    }

}
