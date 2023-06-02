package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.Lesson;
import ru.sevastopall.school_app.domain.SchoolClass;
import ru.sevastopall.school_app.domain.Subject;
import ru.sevastopall.school_app.domain.Teacher;

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
}
