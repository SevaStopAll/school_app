package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.*;

import java.util.Optional;
import java.util.Set;

public interface HomeworkService {
    Optional<Homework> add(Homework homework);
    Set<Homework> findBySubject(Subject subject);
    Set<Homework> findBySchoolClass(SchoolClass schoolClass);
    Set<Homework> findByLesson(Lesson lesson);
    Set<Homework> findByTeacher(Teacher teacher);
}
