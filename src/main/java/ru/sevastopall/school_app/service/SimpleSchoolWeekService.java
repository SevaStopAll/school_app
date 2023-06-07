package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.SchoolWeek;
import ru.sevastopall.school_app.repository.SchoolWeekRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleSchoolWeekService implements SchoolWeekService {
    private SchoolWeekRepository weeks;
    @Override
    public SchoolWeek save(SchoolWeek schoolWeek) {
        return weeks.save(schoolWeek);
    }

    @Override
    public Optional<SchoolWeek> findById(int id) {
        return weeks.findById(id);
    }

    @Override
    public List<SchoolWeek> findAll() {
        return weeks.findAll();
    }
}
