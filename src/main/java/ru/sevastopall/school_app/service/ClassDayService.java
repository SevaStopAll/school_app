package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.ClassDay;
import ru.sevastopall.school_app.domain.SchoolClass;
import ru.sevastopall.school_app.domain.SchoolDay;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Optional;

public interface ClassDayService {
    Optional<ClassDay> save(ClassDay classDay);

    Optional<ClassDay> findById(int id);

    Collection<ClassDay> findBySchoolClass(SchoolClass schoolClass);

    Collection<ClassDay> findBySchoolDay(SchoolDay schoolDay);

    Collection<ClassDay> findAll();

    Optional<ClassDay> findBySchoolClassAndDate(SchoolClass schoolClass, LocalDate date);
}
