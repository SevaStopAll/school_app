package ru.sevastopall.schoolapp.service.impl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sevastopall.schoolapp.domain.Chat;
import ru.sevastopall.schoolapp.domain.ChatMessage;
import ru.sevastopall.schoolapp.domain.Message;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.integration.IntegrationTestBase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleChatServiceTest extends IntegrationTestBase {

    @Autowired private SimpleChatService simpleChatService;
    @Autowired private SimpleChatMessageService simpleChatMessageService;
    @Autowired private SimpleUserService simpleUserService;

    @Test
    public void whenSave() {
    //Arrange
    Chat chat = new Chat();

    //Act
    Chat result = simpleChatService.save(chat);

    //Assert
    Assertions.assertThat(result).isEqualTo(chat);
    }

    @Test
    public void whenFindById() {
        //Arrange
        Chat chat = new Chat();
        Chat savedChat = simpleChatService.save(chat);
        long aimId = savedChat.getId();

        //Act
        Chat result = simpleChatService.findById(aimId);

        //Assert
        Assertions.assertThat(result).isEqualTo(savedChat);

    }

    @Test
    public void whenFindByParticipantsContaining() {
        //Arrange
        Chat chat = new Chat();
        User user1 = new User();
        User participant = simpleUserService.create(user1).get();
        chat.setParticipants(List.of(participant));
        Chat savedChat = simpleChatService.save(chat);

        //Act
        List<Chat> result = simpleChatService.findByParticipantsContaining(participant);

        //Assert
        Assertions.assertThat(result.contains(savedChat)).isTrue();
    }

    @Test
    public void whenFindByMessagesContaining() {
        //Arrange
        Chat chat = new Chat();
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setText("text");
        ChatMessage savedChatMessage = simpleChatMessageService.save(chatMessage);
        chat.setMessages(List.of(savedChatMessage));
        Chat savedChat = simpleChatService.save(chat);

        //Act
        Chat result = simpleChatService.findByMessagesContaining("text");

        //Assert
        Assertions.assertThat(result).isEqualTo(savedChat);
    }


}