package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserByLoginAndPassword(String login, String password);
    Optional<User> findByLogin(String login);
    Optional<User> findById(int userId);
    Optional<User> create(User user);
    List<User> findAll();
}
