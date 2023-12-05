package ru.sevastopall.schoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.schoolapp.domain.Notification;
import ru.sevastopall.schoolapp.domain.User;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

    List<Notification> findAllByUser(User user);


}
