package ru.sevastopall.schoolapp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.sevastopall.schoolapp.domain.News;

public interface NewsRepository extends PagingAndSortingRepository<News, Integer> {

}
