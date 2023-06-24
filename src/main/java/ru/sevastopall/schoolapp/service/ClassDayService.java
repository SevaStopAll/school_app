package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.ClassDay;
import ru.sevastopall.schoolapp.domain.SchoolClass;
import ru.sevastopall.schoolapp.domain.SchoolDay;

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
