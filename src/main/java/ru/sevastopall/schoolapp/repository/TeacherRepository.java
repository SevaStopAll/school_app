package ru.sevastopall.schoolapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.schoolapp.domain.Teacher;
import ru.sevastopall.schoolapp.domain.User;

import java.util.Optional;
import java.util.Set;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    Set<Teacher> findAll();
    Optional<Teacher> findByUser(User user);
}
