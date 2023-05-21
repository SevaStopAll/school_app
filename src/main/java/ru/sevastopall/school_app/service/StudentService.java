package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.Student;

import java.util.Optional;
import java.util.Set;

public interface StudentService {

    Optional<Student> save(Student student);

    Optional<Student> findById(int id);

    Set<Student> findAll();

}
