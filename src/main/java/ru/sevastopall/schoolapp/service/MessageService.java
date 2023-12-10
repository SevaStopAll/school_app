package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.Message;
import ru.sevastopall.schoolapp.domain.User;

import java.util.List;

public interface MessageService {
    Message save(Message message);
    List<Message> findByReceiver(User receiver);
}
