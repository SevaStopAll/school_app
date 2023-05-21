package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.Mark;
import ru.sevastopall.school_app.domain.Student;
import ru.sevastopall.school_app.domain.Subject;
import ru.sevastopall.school_app.domain.Teacher;

import java.util.Collection;
import java.util.Optional;

public interface TeacherService {

    Optional<Teacher> save(Teacher teacher);

    Collection<Teacher> findAll();

}
