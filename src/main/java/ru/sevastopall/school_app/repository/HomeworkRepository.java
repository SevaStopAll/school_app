package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.school_app.domain.*;

import java.util.Set;

@Repository
public interface HomeworkRepository extends CrudRepository<Homework, Integer> {

    Set<Homework> findBySubject(Subject subject);

    Set<Homework> findBySchoolClass(SchoolClass schoolClass);

    Set<Homework> findByLesson(Lesson lesson);
}
