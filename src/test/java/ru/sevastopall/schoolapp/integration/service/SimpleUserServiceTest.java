package ru.sevastopall.schoolapp.integration.service;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sevastopall.schoolapp.integration.IntegrationTestBase;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.repository.UserRepository;
import ru.sevastopall.schoolapp.service.impl.SimpleUserService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleUserServiceTest extends IntegrationTestBase {
    UserRepository userRepository;
    @Autowired
    private final SimpleUserService simpleUserService = new SimpleUserService(userRepository);

    @Test
    public void whenFindAll() {
        //Act
        List<User> users = simpleUserService.findAll();

        //Assert
        assertThat(users.size()).isEqualTo(2);
    }

    @Test
    public void whenFindById() {
        //Arrange
        int testId = 5;

        //Act
        Optional<User> maybeUser = simpleUserService.findById(5);

        //Assert
        Assertions.assertThat(maybeUser.get().getId()).isEqualTo(5);
    }


}