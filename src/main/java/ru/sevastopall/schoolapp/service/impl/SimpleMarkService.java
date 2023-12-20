package ru.sevastopall.schoolapp.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sevastopall.schoolapp.domain.Lesson;
import ru.sevastopall.schoolapp.domain.Mark;
import ru.sevastopall.schoolapp.domain.SchoolClass;
import ru.sevastopall.schoolapp.domain.Student;
import ru.sevastopall.schoolapp.domain.Subject;
import ru.sevastopall.schoolapp.domain.Teacher;
import ru.sevastopall.schoolapp.repository.MarkRepository;
import ru.sevastopall.schoolapp.service.LessonService;
import ru.sevastopall.schoolapp.service.MarkService;


import java.util.*;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class SimpleMarkService implements MarkService {
    private MarkRepository marks;
    private LessonService lessons;

    /**
     * Добавить оценку
     * @param mark оценка
     * @return Optional оценки.
     */
    @Transactional(readOnly = false)
    @Override
    public Optional<Mark> save(Mark mark) {
        return Optional.of(marks.save(mark));
    }

    /**
     * Найти оценки по ученику
     * @param student ученик
     * @return лист оценок.
     */
    @Override
    public List<Mark> findByStudent(Student student) {
        return marks.findByStudent(student);
    }

    /**
     * Найти оценки по учителю
     * @param teacher учитель
     * @return лист оценок.
     */
    @Override
    public List<Mark> findByTeacher(Teacher teacher) {
        return marks.findByTeacher(teacher);
    }

    /**
     * Найти оценки по предмету
     * @param subject предмет
     * @return лист оценок.
     */
    @Override
    public List<Mark> findBySubject(Subject subject) {
        return marks.findBySubject(subject);
    }

    /**
     * Получить информацию по оценкам ученика
     * @param student ученик
     * @return лист оценок ученика по каждому предмету
     */
    @Override
    public Map<String, List<Integer>> getResults(Student student) {
        Map<String, List<Integer>> results = new HashMap<>();
        SchoolClass schoolClass = student.getSchoolClass();
        Set<Lesson> classLessons = lessons.findBySchoolClass(schoolClass);
        List<Subject> studentSubjects = classLessons.stream()
                .map(Lesson::getSubject)
                .distinct()
                .toList();
        System.out.println(studentSubjects.size());
        studentSubjects.forEach(subj -> results.put(subj.getName(), new ArrayList<>()));
            List<Mark> stMark = marks.findByStudent(student);
            for (Mark mark : stMark) {
                String subjName = mark.getSubject().getName();
                if (results.containsKey(subjName)) {
                    results.get(subjName).add(mark.getScore().getId());
                }
            }
        return results;
    }
}
