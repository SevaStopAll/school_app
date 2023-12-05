package ru.sevastopall.schoolapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.ChatMessage;
import ru.sevastopall.schoolapp.repository.ChatMessageRepository;
import ru.sevastopall.schoolapp.service.ChatMessageService;

@Service
@RequiredArgsConstructor
public class SimpleChatMessageService implements ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    @Override
    public ChatMessage save(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }
}
