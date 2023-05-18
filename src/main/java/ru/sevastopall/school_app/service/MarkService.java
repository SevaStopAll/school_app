package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.*;

import java.util.Collection;
import java.util.Optional;

public interface MarkService {

    Optional<Mark> save(Mark mark);

    Collection<Mark> findByStudent(Student student);

    Collection<Mark> findByTeacher(Teacher teacher);

    Collection<Mark> findBySubject(Subject subject);
}
