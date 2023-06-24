package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.*;
import ru.sevastopall.schoolapp.repository.HomeworkRepository;

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
    @Override
    public Set<Homework> findByLesson(Lesson lesson) {
        return homeworkRepository.findByLesson(lesson);
    };
    @Override
    public Set<Homework> findByTeacher(Teacher teacher) {
        return homeworkRepository.findByTeacher(teacher);
    }

}
