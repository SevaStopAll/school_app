package ru.sevastopall.schoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sevastopall.schoolapp.domain.ChatMessage;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
