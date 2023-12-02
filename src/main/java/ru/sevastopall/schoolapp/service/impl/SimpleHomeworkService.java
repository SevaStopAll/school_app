package ru.sevastopall.schoolapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sevastopall.schoolapp.domain.*;
import ru.sevastopall.schoolapp.repository.HomeworkRepository;
import ru.sevastopall.schoolapp.service.HomeworkService;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class SimpleHomeworkService implements HomeworkService {
    private HomeworkRepository homeworkRepository;

    /**
     * Добавить домашнее задание
     * @param homework домашнее задание
     * @return Optional домашнего задания.
     */
    @Transactional(readOnly = false)
    @Override
    public Optional<Homework> add(Homework homework) {
        return Optional.of(homeworkRepository.save(homework));
    }

    /**
     * Найти домашние задания по предмету
     * @param subject предмет
     * @return список домашних заданий.
     */
    @Override
    public Set<Homework> findBySubject(Subject subject) {
        return homeworkRepository.findBySubject(subject);
    }

    /**
     * Найти домашние задания по классу
     * @param schoolClass класс
     * @return лист домашних заданий.
     */
    @Override
    public Set<Homework> findBySchoolClass(SchoolClass schoolClass) {
        return homeworkRepository.findBySchoolClass(schoolClass);
    }

    /**
     * Найти домашние задания по уроку
     * @param lesson урок
     * @return лист домашних заданий.
     */
    @Override
    public Set<Homework> findByLesson(Lesson lesson) {
        return homeworkRepository.findByLesson(lesson);
    };

    /**
     * Найти домашние задания по учителю
     * @param teacher учитель
     * @return лист домашних заданий.
     */
    @Override
    public Set<Homework> findByTeacher(Teacher teacher) {
        return homeworkRepository.findByTeacher(teacher);
    }

}
