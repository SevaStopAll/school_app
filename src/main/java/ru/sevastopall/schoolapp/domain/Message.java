package ru.sevastopall.schoolapp.domain;

import java.time.LocalDateTime;

public class Message {

    private int id;
    private User from;
    private User to;
    private LocalDateTime messageDateTime = LocalDateTime.now();
}
