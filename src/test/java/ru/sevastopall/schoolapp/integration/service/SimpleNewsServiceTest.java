package ru.sevastopall.schoolapp.integration.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sevastopall.schoolapp.domain.News;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.integration.IntegrationTestBase;
import ru.sevastopall.schoolapp.service.impl.SimpleNewsService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleNewsServiceTest extends IntegrationTestBase {
    @Autowired
    private SimpleNewsService simpleNewsService;

    @Test
    public void whenSave() {
        //Arrange
        News news = new News();
        news.setDescription("test");
        news.setHeader("test");
        news.setUser(new User());

        //Act
        News result = simpleNewsService.save(news);

        //Assert
        assertThat(result).isEqualTo(news);
    }

    @Test
    public void whenFindById() {
        //Arrange
        News news = new News();
        news.setDescription("test");
        news.setHeader("test");
        news.setUser(new User());
        News testNews = simpleNewsService.save(news);

        //Act
        News result = simpleNewsService.findById(testNews.getId());

        //Assert
        assertThat(result).isEqualTo(testNews);
    }

    @Test
    public void whenFindAll() {
        //Arrange
        News news = new News();
        news.setDescription("test");
        news.setHeader("test");
        news.setUser(new User());
        simpleNewsService.save(news);

        //Act
        List<News> result = simpleNewsService.findAll();

        //Assert
        assertThat(result.size()).isGreaterThan(0);

    }



}