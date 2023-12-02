package ru.sevastopall.schoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.schoolapp.domain.News;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    @Override
    List<News> findAll();

}
