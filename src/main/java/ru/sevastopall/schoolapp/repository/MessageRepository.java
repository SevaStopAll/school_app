package ru.sevastopall.schoolapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sevastopall.schoolapp.domain.Message;

public interface MessageRepository extends CrudRepository<Message, Long> {
}
