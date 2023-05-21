package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.*;
import ru.sevastopall.school_app.repository.*;


import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleMarkService implements MarkService {
    private MarkRepository marks;
    private SchoolClassRepository classes;
    private TeacherRepository teachers;
    private StudentRepository students;
    private SubjectRepository subjects;

    @Override
    public Optional<Mark> save(Mark mark) {
        return Optional.empty();
    }

    @Override
    public Collection<Mark> findByStudent(Student student) {
        return null;
    }

    @Override
    public Collection<Mark> findByTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public Collection<Mark> findBySubject(Subject subject) {
        return null;
    }
}
