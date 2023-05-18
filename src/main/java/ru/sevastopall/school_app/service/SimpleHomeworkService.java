package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.Homework;
import ru.sevastopall.school_app.domain.Student;
import ru.sevastopall.school_app.domain.Subject;
import ru.sevastopall.school_app.domain.Teacher;

import java.util.Collection;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleHomeworkService implements HomeworkService {

    @Override
    public Optional<Homework> add(Homework homework) {
        return Optional.empty();
    }

    @Override
    public Collection<Homework> findByStudent(Student student) {
        return null;
    }

    @Override
    public Collection<Homework> findByTeacher(Teacher teacher) {
        return null;
    }

    @Override
    public Collection<Homework> findBySubject(Subject subject) {
        return null;
    }
}
