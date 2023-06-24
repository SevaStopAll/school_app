package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.Teacher;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.repository.TeacherRepository;

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

    @Override
    public Optional<Teacher> findByUser(User user) {
        return teachers.findByUser(user);
    }
}
