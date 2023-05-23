package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.school_app.domain.Mark;
import ru.sevastopall.school_app.domain.Subject;
import ru.sevastopall.school_app.domain.Teacher;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface MarkRepository extends CrudRepository<Mark, Integer> {

    List<Mark> findByStudentId(int studentId);

    List<Mark> findByTeacher(Teacher teacher);

    List<Mark> findBySubject(Subject subject);
}
