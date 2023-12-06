package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.Message;
import ru.sevastopall.schoolapp.domain.User;

import java.util.List;

public interface MessageService {
    List<Message> findByReceiver(User receiver);
}
