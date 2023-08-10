package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sevastopall.schoolapp.domain.Subject;
import ru.sevastopall.schoolapp.repository.SubjectRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class SimpleSubjectService implements SubjectService {
    private SubjectRepository subjects;
    /**
     * Создать новый предмет
     *
     * @param subject - новый предмет
     *
     * @return Optional предмета.
     */
    @Transactional(readOnly = false)
    @Override
    public Optional<Subject> save(Subject subject) {
        return Optional.of(subjects.save(subject));
    }


    /**
     * Найти предмет по идентификатору
     *
     * @param id - идентификатор
     *
     * @return Optional предмета.
     */
    @Override
    public Optional<Subject> findById(int id) {
        return subjects.findById(id);
    }

    /**
     * Получить список предметов
     *
     *
     * @return список предметов.
     */
    @Override
    public Set<Subject> findAll() {
        return subjects.findAll();
    }
}
