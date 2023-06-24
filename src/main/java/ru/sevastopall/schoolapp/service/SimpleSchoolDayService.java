package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.SchoolDay;
import ru.sevastopall.schoolapp.domain.SchoolWeek;
import ru.sevastopall.schoolapp.repository.SchoolDayRepository;

import java.util.Collection;
import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class SimpleSchoolDayService implements SchoolDayService {
    private SchoolDayRepository days;

    @Override
    public Optional<SchoolDay> save(SchoolDay day) {
        return Optional.of(days.save(day));
    }

    @Override
    public Optional<SchoolDay> findById(int id) {
        return days.findById(id);
    }

    @Override
    public Optional<SchoolDay> findByName(String name) {
        return days.findByName(name);
    }

    @Override
    public Collection<SchoolDay> findAll() {
        return days.findAll();
    }

    @Override
    public Collection<SchoolDay> findByWeek(SchoolWeek week) {
        return days.findByWeek(week);
    }
}
