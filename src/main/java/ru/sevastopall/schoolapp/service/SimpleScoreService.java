package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.Score;
import ru.sevastopall.schoolapp.repository.ScoreRepository;

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
