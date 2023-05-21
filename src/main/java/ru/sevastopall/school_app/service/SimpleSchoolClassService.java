package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.SchoolClass;
import ru.sevastopall.school_app.repository.SchoolClassRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SimpleSchoolClassService implements SchoolClassService {
    private SchoolClassRepository classes;

    @Override
    public Optional<SchoolClass> save(SchoolClass schoolClass) {
        return Optional.of(classes.save(schoolClass));
    }

    @Override
    public Optional<SchoolClass> findById(int id) {
        return classes.findById(id);
    }

    @Override
    public Set<SchoolClass> findAll() {
        return classes.findAll();
    }
}