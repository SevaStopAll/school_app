package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.*;
import ru.sevastopall.school_app.repository.*;


import java.util.Collection;
import java.util.List;
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
        return Optional.of(marks.save(mark));
    }

    @Override
    public List<Mark> findByStudentId(int studentId) {
        return null;
    }

    @Override
    public List<Mark> findByTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public List<Mark> findBySubject(Subject subject) {
        return null;
    }
}
