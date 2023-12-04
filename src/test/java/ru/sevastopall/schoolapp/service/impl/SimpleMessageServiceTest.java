package ru.sevastopall.schoolapp.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sevastopall.schoolapp.domain.Message;
import ru.sevastopall.schoolapp.integration.IntegrationTestBase;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleMessageServiceTest extends IntegrationTestBase {

    @Autowired
    private SimpleMessageService simpleMessageService;

    @Test
    public void whenSave() {
        //Arrange
        Message testMessage = new Message();

        //Act
        Message result = simpleMessageService.save(testMessage);

        //Assert
        assertThat(result).isEqualTo(testMessage);
    }

}