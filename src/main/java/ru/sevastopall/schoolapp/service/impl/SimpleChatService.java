package ru.sevastopall.schoolapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.Chat;
import ru.sevastopall.schoolapp.domain.ChatMessage;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.repository.ChatRepository;
import ru.sevastopall.schoolapp.service.ChatService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleChatService implements ChatService {
    private final ChatRepository chatRepository;

    public Chat save(Chat chat) {
        return chatRepository.saveAndFlush(chat);
    }

    public Chat findById(Long id) {
        return chatRepository.findById(id).get();
    }

    @Override
    public List<Chat> findByParticipantsContaining(User user) {
        return chatRepository.findByParticipantsContaining(user);
    }

    @Override
    public Chat findByMessagesContaining(String message) {
        return chatRepository.findChatByMessagesContaining(message);
    }

}
