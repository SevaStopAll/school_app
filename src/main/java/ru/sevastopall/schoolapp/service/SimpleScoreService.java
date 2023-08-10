package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sevastopall.schoolapp.domain.Score;
import ru.sevastopall.schoolapp.repository.ScoreRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class SimpleScoreService implements ScoreService {
    private ScoreRepository score;

    /**
     * Найти оценку по id
     *
     *
     * @return Optional оценки.
     */
    @Override
    public Optional<Score> findById(int id) {
        return score.findById(id);
    }

    /**
     * Получить список оценок
     *
     *
     * @return список оценок.
     */
    @Override
    public Set<Score> findAll() {
        return score.findAll();
    }
}
