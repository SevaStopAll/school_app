package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.school_app.domain.SchoolClass;
import ru.sevastopall.school_app.domain.Student;

import java.util.Set;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    Set<Student> findAll();
    Set<Student> findBySchoolClass(SchoolClass schoolClass);
}
