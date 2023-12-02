package ru.sevastopall.schoolapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sevastopall.schoolapp.domain.Lesson;
import ru.sevastopall.schoolapp.domain.SchoolClass;
import ru.sevastopall.schoolapp.domain.Subject;
import ru.sevastopall.schoolapp.domain.Teacher;
import ru.sevastopall.schoolapp.repository.LessonRepository;
import ru.sevastopall.schoolapp.service.LessonService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class SimpleLessonService implements LessonService {
    private final LessonRepository lessons;

    /**
     * Добавить новый урок
     * @param lesson урок
     * @return Optional урока.
     */
    @Transactional(readOnly = false)
    @Override
    public Optional<Lesson> save(Lesson lesson) {
        return Optional.of(lessons.save(lesson));
    }

    /**
     * Найти урок по идентификатору
     * @param id идентификатор
     * @return Optional урока.
     */
    @Override
    public Optional<Lesson> findById(int id) {
        return lessons.findById(id);
    }

    /**
     * Найти уроки по предмету
     * @param subject предмет
     * @return лист уроков.
     */
    @Override
    public Set<Lesson> findBySubject(Subject subject) {
        return lessons.findBySubject(subject);
    }

    /**
     * Найти уроки по классу
     * @param schoolClass класс
     * @return лист уроков.
     */
    @Override
    public Set<Lesson> findBySchoolClass(SchoolClass schoolClass) {
        return lessons.findBySchoolClass(schoolClass);
    }

    /**
     * Найти уроки по учителю
     * @param teacher учитель
     * @return лист уроков.
     */
    @Override
    public Set<Lesson> findByTeacher(Teacher teacher) {
        return lessons.findByTeacher(teacher);
    }

    /**
     * Найти все уроки
     *
     * @return лист уроков.
     */
    @Override
    public Set<Lesson> findAll() {
        return lessons.findAll();
    }

    /**
     * Найти уроки по порядковому номеру урока
     *
     * @param number номер
     * @return лист уроков.
     */
    @Override
    public Set<Lesson> findByNumber(int number) {
        return lessons.findByNumber(number);
    };

    /**
     * Найти уроки по порядковому классу и дате
     *
     * @param schoolClass класс
     * @param date дата
     * @return лист уроков.
     */
    @Override
    public Collection<Lesson> findBySchoolClassAndLessonDate(SchoolClass schoolClass, LocalDate date) {
        return lessons.findBySchoolClassAndLessonDate(schoolClass, date);
    }
}
