package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.Subject;

import java.util.Optional;
import java.util.Set;

public interface SubjectService {

    Optional<Subject> save(Subject subject);

    Optional<Subject> findById(int id);

    Set<Subject> findAll();
}
