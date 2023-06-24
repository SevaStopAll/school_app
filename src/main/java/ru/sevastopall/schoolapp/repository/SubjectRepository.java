package ru.sevastopall.schoolapp.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sevastopall.schoolapp.domain.Subject;

import java.util.Set;

public interface SubjectRepository extends CrudRepository<Subject, Integer> {
    Set<Subject> findAll();
}
