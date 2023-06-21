package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.Student;
import ru.sevastopall.school_app.domain.Teacher;
import ru.sevastopall.school_app.domain.User;

import java.util.Collection;
import java.util.Optional;

public interface TeacherService {

    Optional<Teacher> save(Teacher teacher);

    Collection<Teacher> findAll();

    Optional<Teacher> findById(int id);

    Optional<Teacher> findByUser(User user);

}
