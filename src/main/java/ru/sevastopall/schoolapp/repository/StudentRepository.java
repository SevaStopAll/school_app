package ru.sevastopall.schoolapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.schoolapp.domain.SchoolClass;
import ru.sevastopall.schoolapp.domain.Student;
import ru.sevastopall.schoolapp.domain.User;

import java.util.Optional;
import java.util.Set;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    Set<Student> findAll();
    Set<Student> findBySchoolClass(SchoolClass schoolClass);
    Optional<Student> findByUser(User user);
}
