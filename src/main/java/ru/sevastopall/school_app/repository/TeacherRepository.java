package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.school_app.domain.Student;
import ru.sevastopall.school_app.domain.Teacher;
import ru.sevastopall.school_app.domain.User;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    Set<Teacher> findAll();

    Optional<Teacher> findByUser(User user);
}
