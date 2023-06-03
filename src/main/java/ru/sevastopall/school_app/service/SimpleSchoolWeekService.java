package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.SchoolWeek;

import java.util.List;

@Service
@AllArgsConstructor
public class SimpleSchoolWeekService implements SchoolWeekService {
    @Override
    public SchoolWeek save(SchoolWeek schoolWeek) {
        return null;
    }

    @Override
    public SchoolWeek findById(int id) {
        return null;
    }

    @Override
    public List<SchoolWeek> findAll() {
        return null;
    }
}
