package ru.sevastopall.schoolapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.schoolapp.domain.Mark;
import ru.sevastopall.schoolapp.domain.Student;
import ru.sevastopall.schoolapp.domain.Subject;
import ru.sevastopall.schoolapp.domain.Teacher;

import java.util.List;

@Repository
public interface MarkRepository extends CrudRepository<Mark, Integer> {
    List<Mark> findByStudent(Student student);
    List<Mark> findByTeacher(Teacher teacher);
    List<Mark> findBySubject(Subject subject);
}
