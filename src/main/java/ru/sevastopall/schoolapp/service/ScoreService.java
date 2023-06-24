package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.Score;

import java.util.Optional;
import java.util.Set;

public interface ScoreService {
    Optional<Score> findById(int id);
    Set<Score> findAll();
}
