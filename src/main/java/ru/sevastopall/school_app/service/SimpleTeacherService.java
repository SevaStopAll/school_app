package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.Mark;
import ru.sevastopall.school_app.domain.Teacher;
import ru.sevastopall.school_app.repository.TeacherRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SimpleTeacherService implements TeacherService {
    private TeacherRepository teachers;

    @Override
    public Optional<Teacher> save(Teacher teacher) {
        return Optional.of(teachers.save(teacher));
    }

    @Override
    public Set<Teacher> findAll() {
        return teachers.findAll();
    }

    @Override
    public Optional<Teacher> findById(int id) {
        return teachers.findById(id);
    }
}
