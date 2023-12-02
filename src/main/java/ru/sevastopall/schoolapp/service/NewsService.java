package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.News;

import java.util.List;

public interface NewsService {

    News save(News news);

    News findById(long id);

    List<News> findAll();
}
