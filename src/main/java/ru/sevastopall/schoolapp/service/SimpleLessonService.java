package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.Lesson;
import ru.sevastopall.schoolapp.domain.SchoolClass;
import ru.sevastopall.schoolapp.domain.Subject;
import ru.sevastopall.schoolapp.domain.Teacher;
import ru.sevastopall.schoolapp.repository.LessonRepository;

import java.time.LocalDate;
import java.util.Collection;
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

    @Override
    public Collection<Lesson> findBySchoolClassAndLessonDate(SchoolClass schoolClass, LocalDate date) {
        return lessons.findBySchoolClassAndLessonDate(schoolClass, date);
    }
}
