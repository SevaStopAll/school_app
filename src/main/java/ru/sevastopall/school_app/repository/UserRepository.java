package ru.sevastopall.school_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.User;

import java.util.List;
import java.util.Optional;

@Service
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByLoginAndPassword(String login, String password);
    Optional<User> findByLogin(String login);
    Optional<User> findById(int userId);
    List<User> findAll();
}
