package ru.sevastopall.schoolapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.News;
import ru.sevastopall.schoolapp.repository.NewsRepository;
import ru.sevastopall.schoolapp.service.NewsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleNewsService implements NewsService {
    private final NewsRepository newsRepository;

    @Override
    public News save(News news) {
        return newsRepository.save(news);
    }

    @Override
    public News findById(long id) {
        return newsRepository.findById(id).get();
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }
}
