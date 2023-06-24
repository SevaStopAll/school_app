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
