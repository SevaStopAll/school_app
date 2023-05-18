package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.*;

import java.util.Collection;
import java.util.Optional;

public interface HomeworkService {

    Optional<Homework> add(Homework homework);

    Collection<Homework> findByStudent(Student student);

    Collection<Homework> findByTeacher(Teacher teacher);

    Collection<Homework> findBySubject(Subject subject);

}
