package ru.sevastopall.schoolapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.repository.UserRepository;
import ru.sevastopall.schoolapp.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SimpleUserService implements UserService {
    private final UserRepository users;

    /**
     * Найти пользователя по логину и паролю
     *
     * @param login - логин
     * @param  password пароль
     *
     * @return Optional пользователя.
     */
    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) {
        return users.findUserByLoginAndPassword(login, password);
    }

    /**
     * Найти пользователя по логину
     *
     * @param login - логин
     *
     * @return Optional пользователя.
     */

    @Override
    public Optional<User> findByLogin(String login) {
        return users.findByLogin(login);
    }

    /**
     * Найти пользователя по идентификатору
     *
     * @param userId - идентификатор
     *
     * @return Optional пользователя.
     */
    @Override
    public Optional<User> findById(int userId) {
        return users.findById(userId);
    }

    /**
     * Создать нового пользователя
     *
     * @param user - новый пользователь
     *
     * @return Optional пользователя.
     */
    @Override
    @Transactional(readOnly = false)
    public Optional<User> create(User user) {
        return Optional.of(users.save(user));
    }

    /**
     * Получить список всех пользователей
     *
     *
     * @return список пользователей.
     */
    @Override
    public List<User> findAll() {
        return users.findAll();
    }
}
