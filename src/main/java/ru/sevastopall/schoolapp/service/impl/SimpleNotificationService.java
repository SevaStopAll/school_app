package ru.sevastopall.schoolapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.Notification;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.repository.NotificationRepository;
import ru.sevastopall.schoolapp.service.NotificationService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleNotificationService implements NotificationService {
    private final NotificationRepository notificationRepository;

    @Override
    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public List<Notification> findByUser(User user) {
        return notificationRepository.findAllByUser(user);
    }
}
