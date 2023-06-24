package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.SchoolWeek;

import java.util.List;
import java.util.Optional;

public interface SchoolWeekService {
    SchoolWeek save(SchoolWeek schoolWeek);
    Optional<SchoolWeek> findById(int id);
    List<SchoolWeek> findAll();
}
