package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.Subject;

import java.util.Optional;
import java.util.Set;

public interface SubjectService {

    Optional<Subject> save(Subject subject);

    Optional<Subject> findById(int id);

    Set<Subject> findAll();
}
