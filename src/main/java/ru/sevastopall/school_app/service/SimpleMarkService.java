package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.*;
import ru.sevastopall.school_app.repository.*;


import java.util.*;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SimpleMarkService implements MarkService {
    private MarkRepository marks;
    private SchoolClassRepository classes;
    private TeacherRepository teachers;
    private StudentRepository students;
    private SubjectRepository subjects;
    private LessonService lessons;

    @Override
    public Optional<Mark> save(Mark mark) {
        return Optional.of(marks.save(mark));
    }

    @Override
    public List<Mark> findByStudent(Student student) {
        return marks.findByStudent(student);
    }

    @Override
    public List<Mark> findByTeacher(Teacher teacher) {
        return marks.findByTeacher(teacher);
    }

    @Override
    public List<Mark> findBySubject(Subject subject) {
        return marks.findBySubject(subject);
    }

    @Override
    public Map<String, List<Integer>> getResults(Student student) {
        Map <String, List<Integer>>  results = new HashMap<>();
        SchoolClass schoolClass = student.getSchoolClass();
        Set<Lesson> classLessons = lessons.findBySchoolClass(schoolClass);
        List<Subject> studentSubjects = classLessons.stream()
                .map(Lesson::getSubject)
                .distinct()
                .toList();
        System.out.println(studentSubjects.size());
        studentSubjects.forEach(subj -> results.put(subj.getName(), new ArrayList<>()));
            List <Mark> stMark = marks.findByStudent(student);
            for (Mark mark : stMark) {
                String subjName = mark.getSubject().getName();
                if (results.containsKey(subjName)) {
                    results.get(subjName).add(mark.getScore().getId());
                }
            }
        return results;
    }
}
