package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MarkService {
    Optional<Mark> save(Mark mark);
    List<Mark> findByStudent(Student student);
    List<Mark> findByTeacher(Teacher teacher);
    List<Mark> findBySubject(Subject subject);
    Map<String, List<Integer>> getResults(Student student);
}
