package ru.sevastopall.schoolapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.sevastopall.schoolapp.domain.*;
import ru.sevastopall.schoolapp.service.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
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
        for (int i = 0; i < 5; i++) {
            SchoolDay day = new SchoolDay();
            day.setWeek(schoolWeek);
            day.setDate(schoolWeek.getStartDay().plusDays(i));
            day.setName(day.getDate().getDayOfWeek() + " " + day.getDate());
            days.save(day);
        }
        return "redirect:/";
    }

    @GetMapping("/schedule/week/list")
    public String getWeekList(Model model) {
        model.addAttribute("schoolWeeks", weeks.findAll());
        return "admin/schedule/week/list";
    }

    @GetMapping("/schedule/week/{id}")
    public String getOneWeek(Model model, @PathVariable int id) {
        var weekOptional = weeks.findById(id);
        if (weekOptional.isEmpty()) {
            model.addAttribute("message", "Урока не найдено");
            return "errors/404";
        }
        SchoolWeek week = weekOptional.get();
        Collection<SchoolDay> schoolDays = days.findByWeek(week);
        model.addAttribute("days", schoolDays);
        return "admin/schedule/week/one";
    }


    @GetMapping("/schedule/day/create")
    public String getDayCreationPage(Model model) {
        model.addAttribute("weeks", weeks.findAll());
        return "admin//schedule/day/create";
    }

    @PostMapping("/schedule/day/create")
    public String saveSchoolDay(@ModelAttribute SchoolDay schoolDay, String startDate1, String startDate2, String startDate3, String weekId) {
        schoolDay.setDate(LocalDate.of(
                Integer.parseInt(startDate3), Integer.parseInt(startDate2), Integer.parseInt(startDate1)
        ));
        schoolDay.setWeek(weeks.findById(Integer.parseInt(weekId)).get());
        days.save(schoolDay);
        return "redirect:/";
    }

    @GetMapping("/schedule/day/list")
    public String getSchoolDays(Model model) {
        model.addAttribute("schoolDays", days.findAll());
        return "admin/schedule/day/list";
    }

    @GetMapping("/schedule/day/{id}")
    public String getOneDay(Model model, @PathVariable int id) {
        var dayOptional = days.findById(id);
        if (dayOptional.isEmpty()) {
            model.addAttribute("message", "Урока не найдено");
            return "errors/404";
        }
        SchoolDay schoolDay = dayOptional.get();
        Collection<ClassDay> days = classDays.findBySchoolDay(schoolDay);
        model.addAttribute("days", days);
        return "admin/schedule/day/one";
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
    public String saveClassDay(@ModelAttribute ClassDay classday, Model model,
                               String schoolClass1, String number1, String subject1, String teacher1,
                               String number2, String subject2, String teacher2,
                               String number3, String subject3, String teacher3,
                               String number4, String subject4, String teacher4,
                               String number5, String subject5, String teacher5,
                               String number6, String subject6, String teacher6,
                               String number7, String subject7, String teacher7,
                               String number8, String subject8, String teacher8) {

        LocalDate lessonDate = classday.getSchoolDay().getDate();
        SchoolClass schoolClass = classes.findById(Integer.parseInt(schoolClass1)).get();
        if (classDays.findBySchoolClassAndDate(schoolClass, lessonDate).isPresent()) {
            model.addAttribute("message", "Расписание для класса на этот день уже существует");
            return "errors/404";
        }
        classday.setSchoolClass(schoolClass);
        List<Lesson> lessonSet = new ArrayList<>();

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
        classday.setName(classday.getSchoolClass().getName() + " " + classday.getDate());
        classDays.save(classday);
        return "redirect:/";
    }

    @GetMapping("/schedule/class/list")
    public String getClassDays(Model model) {
        model.addAttribute("classDays", classDays.findAll());
        return "admin/schedule/class/list";
    }

    @GetMapping("/schedule/class/{id}")
    public String getOneClassDay(Model model, @PathVariable int id) {
        var classDayOptional = classDays.findById(id);
        if (classDayOptional.isEmpty()) {
            model.addAttribute("message", "Урока не найдено");
            return "errors/404";
        }
        ClassDay classDay = classDayOptional.get();
        Collection<Lesson> classDayLessons = lessons.findBySchoolClassAndLessonDate(classDay.getSchoolClass(), classDay.getDate());
        model.addAttribute("lessons", classDayLessons);
        return "admin/schedule/class/one";
    }

    private Lesson createNewLesson(LocalDate lessonDate, String schoolClass, String number, String subject, String teacher) {
        Lesson lesson = new Lesson();
        lesson.setLessonDate(lessonDate);
        lesson.setNumber(Integer.parseInt(number));
        lesson.setSubject(subjects.findById(Integer.parseInt(subject)).get());
        lesson.setSchoolClass(classes.findById(Integer.parseInt(schoolClass)).get());
        lesson.setTeacher(teachers.findById(Integer.parseInt(teacher)).get());
        StringBuilder builder = new StringBuilder();
        builder.append(lesson.getLessonDate()).append(" ").append(lesson.getSchoolClass().getName()).append(" ").append(lesson.getNumber()).append(" ").append(lesson.getSubject().getName());
        lesson.setName(builder.toString());
        return lessons.save(lesson).get();
    }
}
