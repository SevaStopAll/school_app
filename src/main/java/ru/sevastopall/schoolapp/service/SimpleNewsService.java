package ru.sevastopall.schoolapp.service;

import org.springframework.transaction.annotation.Transactional;
import ru.sevastopall.schoolapp.domain.News;

import java.util.Optional;
@Transactional(readOnly = true)
public class SimpleNewsService implements NewsService {

    @Override
    @Transactional(readOnly = false)
    public Optional<News> create(News news) {
        return null;
    }

    @Override
    public Optional<News> findById(int newsId) {
        return null;
    }

    public Iterable<News> findAll() {
        return null;
    }


}
