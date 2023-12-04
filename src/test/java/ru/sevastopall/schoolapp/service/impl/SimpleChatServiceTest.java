package ru.sevastopall.schoolapp.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sevastopall.schoolapp.domain.Chat;
import ru.sevastopall.schoolapp.domain.Message;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.integration.IntegrationTestBase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleChatServiceTest extends IntegrationTestBase {

    @Autowired private SimpleChatService simpleChatService;

    @Test
    public void whenSave() {
    //Arrange

    //Act
    simpleChatService.save();
    //Assert

    }

    @Test
    public void whenFindById() {
        //Arrange

        //Act
        simpleChatService.findById();
        //Assert
    }
    @Test
    public void whenFindByParticipantsContaining() {
        //Arrange

        //Act
        simpleChatService.findByParticipantsContaining();
        //Assert
    }

    @Test
    public void whenFindByMessagesContaining() {
        //Arrange

        //Act
        simpleChatService.findByMessagesContaining();
        //Assert
    }


}