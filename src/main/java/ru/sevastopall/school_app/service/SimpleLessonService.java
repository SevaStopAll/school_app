package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.Lesson;
import ru.sevastopall.school_app.domain.SchoolClass;
import ru.sevastopall.school_app.domain.Subject;
import ru.sevastopall.school_app.domain.Teacher;
import ru.sevastopall.school_app.repository.LessonRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SimpleLessonService implements LessonService {
    private final LessonRepository lessons;

    @Override
    public Optional<Lesson> save(Lesson lesson) {
        return Optional.of(lessons.save(lesson));
    }

    @Override
    public Optional<Lesson> findById(int id) {
        return lessons.findById(id);
    }

    @Override
    public Set<Lesson> findBySubject(Subject subject) {
        return lessons.findBySubject(subject);
    }

    @Override
    public Set<Lesson> findBySchoolClass(SchoolClass schoolClass) {
        return lessons.findBySchoolClass(schoolClass);
    }

    @Override
    public Set<Lesson> findByTeacher(Teacher teacher) {
        return lessons.findByTeacher(teacher);
    }

    @Override
    public Set<Lesson> findAll() {
        return lessons.findAll();
    }
    @Override
    public Set<Lesson> findByNumber(int number) {
        return lessons.findByNumber(number);
    };
}
