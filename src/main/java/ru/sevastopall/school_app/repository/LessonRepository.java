package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.school_app.domain.Lesson;
import ru.sevastopall.school_app.domain.SchoolClass;
import ru.sevastopall.school_app.domain.Subject;
import ru.sevastopall.school_app.domain.Teacher;

import java.util.Optional;
import java.util.Set;

@Repository
public interface LessonRepository extends CrudRepository<Lesson, Integer> {

    Optional<Lesson> findById(int id);

    Set<Lesson> findAll();

    Set<Lesson> findByNumber(int number);

    Set<Lesson> findBySubject(Subject subject);

    Set<Lesson> findBySchoolClass(SchoolClass schoolClass);

    Set<Lesson> findByTeacher(Teacher teacher);
}
