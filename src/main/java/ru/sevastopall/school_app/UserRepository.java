package ru.sevastopall.school_app;

import java.util.Optional;

public interface UserRepository {

    Optional<User> save(User user);

    Optional<User> findByEmailAndPassword(String email, String password);

}
