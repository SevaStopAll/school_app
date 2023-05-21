package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.Subject;
import ru.sevastopall.school_app.repository.SubjectRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SimpleSubjectService implements SubjectService {
    private SubjectRepository subjects;

    @Override
    public Optional<Subject> save(Subject subject) {
        return Optional.of(subjects.save(subject));
    }

    @Override
    public Optional<Subject> findById(int id) {
        return subjects.findById(id);
    }

    @Override
    public Set<Subject> findAll() {
        return subjects.findAll();
    }
}
