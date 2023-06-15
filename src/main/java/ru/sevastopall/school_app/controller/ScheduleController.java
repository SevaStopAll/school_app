package ru.sevastopall.school_app.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sevastopall.school_app.domain.*;
import ru.sevastopall.school_app.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
@AllArgsConstructor
public class ScheduleController {
    private SchoolClassService classes;
    private LessonService lessons;
    private SchoolDayService days;
    private ClassDayService classDays;

    private TeacherService teachers;
    private SubjectService subjects;

    private SchoolWeekService weeks;

    @GetMapping("/schedule/day/create")
    public String getDayCreationPage(Model model) {
        model.addAttribute("weeks", weeks.findAll());
        return "admin//schedule/day/create";
    }

    @PostMapping("/schedule/day/create")
    public String saveSchoolDay(@ModelAttribute SchoolDay schoolDay, String startDate1, String startDate2, String startDate3) {
        schoolDay.setDate(LocalDate.of(
                Integer.parseInt(startDate3), Integer.parseInt(startDate2), Integer.parseInt(startDate1)
        ));
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
        model.addAttribute("classes", classes.findAll());
        model.addAttribute("teachers", teachers.findAll());
        model.addAttribute("subjects", subjects.findAll());
        return "admin/schedule/class/create";
    }

    @PostMapping("/schedule/class/create")
    public String saveClassDay(@ModelAttribute ClassDay classday,
                               String lessonDate1, String lessonDate2, String lessonDate3, String schoolClass1, String number1, String subject1, String teacher1,
                               String number2, String subject2, String teacher2,
                               String number3, String subject3, String teacher3,
                               String number4, String subject4, String teacher4,
                               String number5, String subject5, String teacher5,
                               String number6, String subject6, String teacher6,
                               String number7, String subject7, String teacher7,
                               String number8, String subject8, String teacher8) {
        List<Lesson> lessonSet = new ArrayList<>();
        LocalDate lessonDate = LocalDate.of(
                Integer.parseInt(lessonDate3), Integer.parseInt(lessonDate2), Integer.parseInt(lessonDate1)
        );
        classday.setDate(lessonDate);
        if (!number1.equals("0")) {
            lessonSet.add(createNewLesson(lessonDate, schoolClass1, number1, subject1, teacher1));
        }
        if (!number2.equals("0")) {
            lessonSet.add(createNewLesson(lessonDate, schoolClass1, number2, subject2, teacher2));
        }
        if (!number3.equals("0")) {
            lessonSet.add(createNewLesson(lessonDate, schoolClass1, number3, subject3, teacher3));
        }
        if (!number4.equals("0")) {
            lessonSet.add(createNewLesson(lessonDate, schoolClass1, number4, subject4, teacher4));
        }
        if (!number5.equals("0")) {
            lessonSet.add(createNewLesson(lessonDate, schoolClass1, number5, subject5, teacher5));
        }
        if (!number6.equals("0")) {
            lessonSet.add(createNewLesson(lessonDate, schoolClass1, number6, subject6, teacher6));
        }
        if (!number7.equals("0")) {
            lessonSet.add(createNewLesson(lessonDate, schoolClass1, number7, subject7, teacher7));
        }
        if (!number8.equals("0")) {
            lessonSet.add(createNewLesson(lessonDate, schoolClass1, number8, subject8, teacher8));
        }
        classday.setLessons(lessonSet);

        classday.setSchoolClass(classes.findById(Integer.parseInt(schoolClass1)).get());
        classDays.save(classday);
        return "redirect:/";
    }

    @GetMapping("/schedule/class/list")
    public String getClassDays(Model model) {
        model.addAttribute("classDays", classDays.findAll());
        return "admin/schedule/class/list";
    }

    private Lesson createNewLesson(LocalDate lessonDate, String schoolClass, String number, String subject, String teacher) {
        Lesson lesson = new Lesson();
        lesson.setLessonDate(lessonDate);
        lesson.setNumber(Integer.parseInt(number));
        lesson.setSubject(subjects.findById(Integer.parseInt(subject)).get());
        lesson.setSchoolClass(classes.findById(Integer.parseInt(schoolClass)).get());
        lesson.setTeacher(teachers.findById(Integer.parseInt(teacher)).get());
        lesson.setName(lesson.getLessonDate() + lesson.getSchoolClass().getName() + lesson.getNumber() + lesson.getSubject().getName());
        return lessons.save(lesson).get();
    }

    @GetMapping("/schedule/week/create")
    public String getWeekCreationPage() {
        return "admin/schedule/week/create";
    }

    @PostMapping("/schedule/week/create")
    public String saveSchoolWeek(@ModelAttribute SchoolWeek schoolWeek,
                               String startDate1, String startDate2, String startDate3,
                               String endDate1, String endDate2, String endDate3) {
        schoolWeek.setStartDay(LocalDate.of(
                Integer.parseInt(startDate3), Integer.parseInt(startDate2), Integer.parseInt(startDate1)
        ));
        schoolWeek.setEndDay(LocalDate.of(
                Integer.parseInt(endDate3), Integer.parseInt(endDate2), Integer.parseInt(endDate1)
        ));
        weeks.save(schoolWeek);
        return "redirect:/";
    }
}
