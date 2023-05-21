package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sevastopall.school_app.domain.Subject;

import java.util.Set;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    Set<Subject> findAll();
}
