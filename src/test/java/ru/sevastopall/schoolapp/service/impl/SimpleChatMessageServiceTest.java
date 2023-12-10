package ru.sevastopall.schoolapp.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sevastopall.schoolapp.domain.ChatMessage;
import ru.sevastopall.schoolapp.integration.IntegrationTestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleChatMessageServiceTest extends IntegrationTestBase {
    @Autowired private SimpleChatMessageService service;

    @Test
            public void whenSave_dataSaved() {
        //Arrange
        ChatMessage chatMessage = new ChatMessage();


        //Act


        //Assert
    }





}