package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.SchoolClass;
import ru.sevastopall.schoolapp.domain.Student;
import ru.sevastopall.schoolapp.domain.User;

import java.util.Optional;
import java.util.Set;

public interface StudentService {

    Optional<Student> save(Student student);

    Optional<Student> findById(int id);

    Set<Student> findAll();

    Set<Student> findBySchoolClass(SchoolClass schoolClass);

    Optional<Student> findByUser(User user);

}
