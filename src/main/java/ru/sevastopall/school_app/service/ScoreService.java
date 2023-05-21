package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.Score;

import java.util.Optional;
import java.util.Set;

public interface ScoreService {
    Optional<Score> findById(int id);

    Set<Score> findAll();
}
