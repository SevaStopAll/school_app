package ru.sevastopall.schoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.schoolapp.domain.Chat;
import ru.sevastopall.schoolapp.domain.ChatMessage;
import ru.sevastopall.schoolapp.domain.Message;
import ru.sevastopall.schoolapp.domain.User;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findByParticipantsContaining(User user);

    List<Chat> findByMessagesContaining(ChatMessage message);

}
