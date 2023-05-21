package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sevastopall.school_app.domain.Score;

import java.util.Optional;
import java.util.Set;

public interface ScoreRepository extends CrudRepository<Score, Integer> {

    Optional<Score> findById(int id);

    Set<Score> findAll();

}
