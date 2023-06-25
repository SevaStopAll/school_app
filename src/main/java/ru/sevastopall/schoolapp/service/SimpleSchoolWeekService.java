package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.SchoolWeek;
import ru.sevastopall.schoolapp.repository.SchoolWeekRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleSchoolWeekService implements SchoolWeekService {
    private SchoolWeekRepository weeks;

    /**
     * Сохранить новую школьную неделю
     * @param schoolWeek Школьная неделя
     * @return сохраненная школьная неделя.
     */
    @Override
    public SchoolWeek save(SchoolWeek schoolWeek) {
        return weeks.save(schoolWeek);
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
