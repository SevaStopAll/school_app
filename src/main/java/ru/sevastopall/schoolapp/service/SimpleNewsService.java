package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.News;

import java.util.Optional;

public class SimpleNewsService implements NewsService {

    @Override
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
