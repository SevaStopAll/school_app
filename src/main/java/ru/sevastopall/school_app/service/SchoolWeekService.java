package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.SchoolWeek;

import java.util.List;

public interface SchoolWeekService {
    SchoolWeek save(SchoolWeek schoolWeek);

    SchoolWeek findById(int id);

    List<SchoolWeek> findAll();
}
