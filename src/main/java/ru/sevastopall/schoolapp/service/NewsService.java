package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.News;

import java.util.Optional;

public interface NewsService {

    Optional<News> create(News news);

    Optional<News> findById(int newsId);

    Iterable<News> findAll();
}
