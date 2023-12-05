package ru.sevastopall.schoolapp.service;

import org.springframework.stereotype.Repository;
import ru.sevastopall.schoolapp.domain.ChatMessage;

@Repository
public interface ChatMessageService {
    ChatMessage save(ChatMessage chatMessage);
}
