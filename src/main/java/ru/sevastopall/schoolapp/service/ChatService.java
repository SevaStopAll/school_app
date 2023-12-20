package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.Chat;
import ru.sevastopall.schoolapp.domain.ChatMessage;
import ru.sevastopall.schoolapp.domain.Message;
import ru.sevastopall.schoolapp.domain.User;

import java.util.List;

public interface ChatService {

    List<Chat> findByParticipantsContaining(User user);

    Chat save(Chat chat);

    Chat findById(Long id);

    Chat findByMessagesContaining(String message);
}
