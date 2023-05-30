package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findUserByLoginAndPassword(String login, String password);
    Optional<User> findByLogin(String login);
    Optional<User> findById(int userId);
    Optional<User> create(User user);
}
