package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.*;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface HomeworkService {

    Optional<Homework> add(Homework homework);

    Set<Homework> findBySubject(Subject subject);

    Set<Homework> findBySchoolClass(SchoolClass schoolClass);

    Set<Homework> findByLesson(Lesson lesson);

    Set<Homework> findByTeacher(Teacher teacher);
}
