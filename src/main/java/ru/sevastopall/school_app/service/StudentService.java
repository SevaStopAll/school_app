package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.SchoolClass;
import ru.sevastopall.school_app.domain.Student;
import ru.sevastopall.school_app.domain.User;

import java.util.Optional;
import java.util.Set;

public interface StudentService {

    Optional<Student> save(Student student);

    Optional<Student> findById(int id);

    Set<Student> findAll();

    Set<Student> findBySchoolClass(SchoolClass schoolClass);

    Optional<Student> findByUser(User user);

}
