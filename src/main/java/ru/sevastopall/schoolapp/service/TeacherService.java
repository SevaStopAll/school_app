package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.Teacher;
import ru.sevastopall.schoolapp.domain.User;

import java.util.Collection;
import java.util.Optional;

public interface TeacherService {

    Optional<Teacher> save(Teacher teacher);

    Collection<Teacher> findAll();

    Optional<Teacher> findById(int id);

    Optional<Teacher> findByUser(User user);

}
