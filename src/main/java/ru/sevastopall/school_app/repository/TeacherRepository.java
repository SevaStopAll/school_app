package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.school_app.domain.Teacher;

import java.util.Set;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer> {
    Set<Teacher> findAll();
}
