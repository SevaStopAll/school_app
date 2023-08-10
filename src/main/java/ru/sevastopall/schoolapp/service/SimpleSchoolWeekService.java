package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sevastopall.schoolapp.domain.SchoolWeek;
import ru.sevastopall.schoolapp.repository.SchoolWeekRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class SimpleSchoolWeekService implements SchoolWeekService {
    private SchoolWeekRepository weeks;

    /**
     * Сохранить новую школьную неделю
     * @param schoolWeek Школьная неделя
     * @return сохраненная школьная неделя.
     */
    @Transactional(readOnly = false)
    @Override
    public Optional<SchoolWeek> save(SchoolWeek schoolWeek) {
        return Optional.of(weeks.save(schoolWeek));
    }

    /**
     * Найти школьную неделю по идентификатору
     * @param id идентификатор недели
     * @return Optional школьной недели.
     */
    @Override
    public Optional<SchoolWeek> findById(int id) {
        return weeks.findById(id);
    }

    /**
     * Получить все школьные недели
     *
     * @return список школьных недель.
     */
    @Override
    public List<SchoolWeek> findAll() {
        return weeks.findAll();
    }
}
