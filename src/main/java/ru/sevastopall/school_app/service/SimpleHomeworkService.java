package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.*;
import ru.sevastopall.school_app.repository.HomeworkRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SimpleHomeworkService implements HomeworkService {
    private HomeworkRepository homeworkRepository;

    @Override
    public Optional<Homework> add(Homework homework) {
        return Optional.of(homeworkRepository.save(homework));
    }

    @Override
    public Set<Homework> findBySubject(Subject subject) {
        return homeworkRepository.findBySubject(subject);
    }

    @Override
    public Set<Homework> findBySchoolClass(SchoolClass schoolClass) {
        return homeworkRepository.findBySchoolClass(schoolClass);
    }

    public Set<Homework> findByLesson(Lesson lesson) {
        return homeworkRepository.findByLesson(lesson);
    };

}
