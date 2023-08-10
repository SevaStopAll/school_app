package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sevastopall.schoolapp.domain.Teacher;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.repository.TeacherRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class SimpleTeacherService implements TeacherService {
    private TeacherRepository teachers;

    /**
     * Создать нового учителя
     *
     * @param teacher - новый учитель
     *
     * @return Optional учителя.
     */
    @Transactional(readOnly = false)
    @Override
    public Optional<Teacher> save(Teacher teacher) {
        return Optional.of(teachers.save(teacher));
    }

    /**
     * Получить список всех учителей
     *
     *
     * @return список учителей.
     */
    @Override
    public Set<Teacher> findAll() {
        return teachers.findAll();
    }

    /**
     * Получить список учителей
     *
     *
     * @return список учителей.
     */

    @Override
    public Optional<Teacher> findById(int id) {
        return teachers.findById(id);
    }

    /**
     * Найти учителя по пользователю сервиса
     *
     * @param user - пользователь
     *
     * @return Optional учителя.
     */

    @Override
    public Optional<Teacher> findByUser(User user) {
        return teachers.findByUser(user);
    }
}
