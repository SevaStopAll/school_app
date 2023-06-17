package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.school_app.domain.*;

import java.time.LocalDate;
import java.util.Collection;
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

    Collection<Lesson> findBySchoolClassAndLessonDate(SchoolClass schoolClass, LocalDate date);
}
