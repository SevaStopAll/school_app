package ru.sevastopall.schoolapp.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sevastopall.schoolapp.domain.Notification;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.integration.IntegrationTestBase;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SimpleNotificationServiceTest extends IntegrationTestBase {
    @Autowired private SimpleNotificationService service;

    @Test
    public void whenSave_dataSaved() {
        //Arrange
        Notification notification = new Notification();

        //Act
        Notification result = service.save(notification);

        //Assert
        assertThat(result).isEqualTo(notification);
    }

    @Test
    public void whenFind_dataFound() {
        //Arrange
        User user = new User();
        Notification notification = new Notification();
        notification.setUser(user);
        Notification notification2 = new Notification();
        notification2.setUser(user);

        //Act
        List<Notification> result = service.findByUser(user);

        //Assert
        assertThat(result.size()).isEqualTo(2);


    }

}