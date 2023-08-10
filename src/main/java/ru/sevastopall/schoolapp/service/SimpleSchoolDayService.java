package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sevastopall.schoolapp.domain.SchoolDay;
import ru.sevastopall.schoolapp.domain.SchoolWeek;
import ru.sevastopall.schoolapp.repository.SchoolDayRepository;

import java.util.Collection;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
@Transactional(readOnly = true)
public class SimpleSchoolDayService implements SchoolDayService {
    private SchoolDayRepository days;
    /**
     * Сохранить новый школьный день
     * @param day школьный день
     * @return Optional школьного дня.
     */
    @Transactional(readOnly = false)
    @Override
    public Optional<SchoolDay> save(SchoolDay day) {
        return Optional.of(days.save(day));
    }

    /**
     * Найти учебный день по идентификатору
     * @param id идентификатор дня
     * @return Optional учебного дня.
     */
    @Override
    public Optional<SchoolDay> findById(int id) {
        return days.findById(id);
    }

    /**
     * Найти учебный день по названию
     * @param name названию
     * @return Optional учебного дня.
     */
    @Override
    public Optional<SchoolDay> findByName(String name) {
        return days.findByName(name);
    }

    /**
     * Получить список учебных дней
     *
     *
     * @return список учебных дней.
     */
    @Override
    public Collection<SchoolDay> findAll() {
        return days.findAll();
    }

    /**
     * Найти учебный день по учебной неделе
     * @param week неделе
     * @return Optional учебного дня.
     */
    @Override
    public Collection<SchoolDay> findByWeek(SchoolWeek week) {
        return days.findByWeek(week);
    }
}
