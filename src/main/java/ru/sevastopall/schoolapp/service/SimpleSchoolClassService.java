package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.SchoolClass;
import ru.sevastopall.schoolapp.repository.SchoolClassRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SimpleSchoolClassService implements SchoolClassService {
    private SchoolClassRepository classes;

    /**
     * Сохранить новый класс
     * @param schoolClass класс
     * @return Optional класса.
     */
    @Override
    public Optional<SchoolClass> save(SchoolClass schoolClass) {
        return Optional.of(classes.save(schoolClass));
    }

    /**
     * Найти класс по идентификатору
     * @param id идентификатор класса
     * @return Optional класса.
     */
    @Override
    public Optional<SchoolClass> findById(int id) {
        return classes.findById(id);
    }

    /**
     * Получить список классов
     * @return список классов.
     */
    @Override
    public Set<SchoolClass> findAll() {
        return classes.findAll();
    }
}
