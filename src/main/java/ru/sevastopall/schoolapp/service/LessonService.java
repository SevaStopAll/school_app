package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.Lesson;
import ru.sevastopall.schoolapp.domain.SchoolClass;
import ru.sevastopall.schoolapp.domain.Subject;
import ru.sevastopall.schoolapp.domain.Teacher;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface LessonService {
    Optional<Lesson> save(Lesson lesson);
    Optional<Lesson> findById(int id);
    Set<Lesson> findBySubject(Subject subject);
    Set<Lesson> findBySchoolClass(SchoolClass schoolClass);
    Set<Lesson> findByTeacher(Teacher teacher);
    Set<Lesson> findAll();
    Set<Lesson> findByNumber(int number);
    Collection<Lesson> findBySchoolClassAndLessonDate(SchoolClass schoolClass, LocalDate date);
}
