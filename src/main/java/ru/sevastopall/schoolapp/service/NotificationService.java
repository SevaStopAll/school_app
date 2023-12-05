package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.Notification;
import ru.sevastopall.schoolapp.domain.User;

import java.util.List;

public interface NotificationService {
    Notification save(Notification notification);

    List<Notification> findByUser(User user);
}
