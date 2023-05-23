package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MarkService {

    Optional<Mark> save(Mark mark);

    List<Mark> findByStudentId(int studentId);

    List<Mark> findByTeacher(Teacher teacher);

    List<Mark> findBySubject(Subject subject);
}
