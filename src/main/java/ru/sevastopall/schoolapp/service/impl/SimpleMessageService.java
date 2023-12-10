package ru.sevastopall.schoolapp.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.Message;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.repository.MessageRepository;
import ru.sevastopall.schoolapp.service.MessageService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SimpleMessageService implements MessageService {
    private final MessageRepository messageRepository;

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public List<Message> findByReceiver(User receiver) {
        return messageRepository.findByReceiver(receiver);
    }

}
