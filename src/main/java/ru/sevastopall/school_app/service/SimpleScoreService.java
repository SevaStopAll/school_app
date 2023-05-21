package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.Score;
import ru.sevastopall.school_app.repository.ScoreRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SimpleScoreService implements ScoreService {
    private ScoreRepository score;


    @Override
    public Optional<Score> findById(int id) {
        return score.findById(id);
    }

    @Override
    public Set<Score> findAll() {
        return score.findAll();
    }
}
