package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sevastopall.schoolapp.domain.SchoolClass;
import ru.sevastopall.schoolapp.domain.Student;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.repository.StudentRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class SimpleStudentService implements StudentService {
    private StudentRepository students;

    /**
     * Создать нового ученика
     *
     * @param student - новый ученик
     *
     * @return Optional учителя.
     */
    @Transactional(readOnly = false)
    @Override
    public Optional<Student> save(Student student) {
        return Optional.of(students.save(student));
    }

    /**
     * Найти ученика по идентификатору
     *
     * @param id - идентификатор
     *
     * @return Optional ученика.
     */
    @Override
    public Optional<Student> findById(int id) {
        return students.findById(id);
    }

    /**
     * Получить список всех учеников
     *
     *
     * @return список учеников.
     */
    @Override
    public Set<Student> findAll() {
        return students.findAll();
    }

    /**
     * Получить список всех учеников из класса
     *
     * @param schoolClass класс, в котором нужно найти всех учеников
     *
     * @return список учеников.
     */
    @Override
    public Set<Student> findBySchoolClass(SchoolClass schoolClass) {
        return students.findBySchoolClass(schoolClass);
    }

    /**
     * Найти ученика по пользователю сервиса
     *
     * @param user - пользователь
     *
     * @return Optional ученика.
     */
    @Override
    public Optional<Student> findByUser(User user) {
        return students.findByUser(user);
    }
}
