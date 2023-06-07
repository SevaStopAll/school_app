package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.SchoolWeek;

import java.util.List;
import java.util.Optional;

public interface SchoolWeekService {
    SchoolWeek save(SchoolWeek schoolWeek);

    Optional<SchoolWeek> findById(int id);

    List<SchoolWeek> findAll();
}
