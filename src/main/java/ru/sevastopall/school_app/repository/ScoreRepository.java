package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sevastopall.school_app.domain.Score;

public interface ScoreRepository extends CrudRepository<Score, Integer> {

}
