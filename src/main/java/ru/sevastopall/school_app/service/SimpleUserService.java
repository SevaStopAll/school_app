package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.User;
import ru.sevastopall.school_app.repository.UserRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SimpleUserService implements UserService {
    private final UserRepository users;

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) {
        return users.findUserByLoginAndPassword(login, password);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return users.findByLogin(login);
    }

    @Override
    public Optional<User> findById(int userId) {
        return users.findById(userId);
    }

    @Override
    public Optional<User> create(User user) {
        return Optional.of(users.save(user));
    }
}
