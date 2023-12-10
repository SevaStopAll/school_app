package ru.sevastopall.schoolapp.service;

import org.springframework.stereotype.Repository;
import ru.sevastopall.schoolapp.domain.Chat;
import ru.sevastopall.schoolapp.domain.ChatMessage;

import java.util.List;

@Repository
public interface ChatMessageService {
    ChatMessage save(ChatMessage chatMessage);

    List<ChatMessage> findByChat(Chat chat);
}
