package ru.sevastopall.schoolapp.mapper;

import org.springframework.stereotype.Component;
import ru.sevastopall.schoolapp.domain.Homework;
import ru.sevastopall.schoolapp.dto.HomeworkReadDto;

@Component
public class HomeworkReadMapper implements Mapper<Homework, HomeworkReadDto> {

    @Override
    public HomeworkReadDto map(Homework object) {
        return new HomeworkReadDto(
                object.getId(),
                object.getDescription(),
                object.getSchoolClass().getName(),
                object.getSubject().getName(),
                object.getLesson().getName(),
                object.getTeacher().getLastName()
        );
    }
}
