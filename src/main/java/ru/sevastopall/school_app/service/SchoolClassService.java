package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.SchoolClass;

import java.util.Optional;
import java.util.Set;

public interface SchoolClassService {

    Optional<SchoolClass> save(SchoolClass schoolClass);

    Optional<SchoolClass> findById(int id);

    Set<SchoolClass> findAll();

}
