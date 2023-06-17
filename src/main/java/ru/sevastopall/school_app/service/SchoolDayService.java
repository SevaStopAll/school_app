package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.SchoolDay;
import ru.sevastopall.school_app.domain.SchoolWeek;

import java.util.Collection;
import java.util.Optional;

public interface SchoolDayService {
    Optional<SchoolDay> save(SchoolDay day);

    Optional<SchoolDay> findById(int id);

    Optional<SchoolDay> findByName(String name);

    Collection<SchoolDay> findAll();

    Collection<SchoolDay> findByWeek(SchoolWeek week);
}
