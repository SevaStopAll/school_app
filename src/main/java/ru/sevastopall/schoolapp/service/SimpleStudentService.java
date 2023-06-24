package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.SchoolClass;
import ru.sevastopall.schoolapp.domain.Student;
import ru.sevastopall.schoolapp.domain.User;
import ru.sevastopall.schoolapp.repository.StudentRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SimpleStudentService implements StudentService {
    private StudentRepository students;

    @Override
    public Optional<Student> save(Student student) {
        return Optional.of(students.save(student));
    }

    @Override
    public Optional<Student> findById(int id) {
        return students.findById(id);
    }

    @Override
    public Set<Student> findAll() {
        return students.findAll();
    }

    @Override
    public Set<Student> findBySchoolClass(SchoolClass schoolClass) {
        return students.findBySchoolClass(schoolClass);
    }

    @Override
    public Optional<Student> findByUser(User user) {
        return students.findByUser(user);
    }
}
