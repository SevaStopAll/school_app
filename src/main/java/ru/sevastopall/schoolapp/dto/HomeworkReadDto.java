package ru.sevastopall.schoolapp.dto;

import lombok.Value;

@Value
public class HomeworkReadDto {
    int id;

    String description;

    String schoolClass;

    String subject;

    String lesson;

    String teacher;
}
