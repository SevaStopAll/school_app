package ru.sevastopall.schoolapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.Chat;
import ru.sevastopall.schoolapp.domain.ChatMessage;
import ru.sevastopall.schoolapp.repository.ChatMessageRepository;
import ru.sevastopall.schoolapp.service.ChatMessageService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleChatMessageService implements ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    @Override
    public ChatMessage save(ChatMessage chatMessage) {
        return chatMessageRepository.saveAndFlush(chatMessage);
    }

    @Override
    public List<ChatMessage> findByChat(Chat chat) {
        return chatMessageRepository.findByChat(chat);
    }
}
