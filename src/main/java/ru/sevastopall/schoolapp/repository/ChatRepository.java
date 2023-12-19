package ru.sevastopall.schoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.sevastopall.schoolapp.domain.Chat;
import ru.sevastopall.schoolapp.domain.ChatMessage;
import ru.sevastopall.schoolapp.domain.Message;
import ru.sevastopall.schoolapp.domain.User;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findByParticipantsContaining(User user);

    @Query(value = "SELECT * FROM chat JOIN chat_message ON chat.id = chat_message.chat_id WHERE chat_message.text = ?1", nativeQuery = true)
    Chat findChatByMessagesContaining(String message);

    Chat saveAndFlush(Chat chat);
}
