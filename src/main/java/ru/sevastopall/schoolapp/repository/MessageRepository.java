package ru.sevastopall.schoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.schoolapp.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
