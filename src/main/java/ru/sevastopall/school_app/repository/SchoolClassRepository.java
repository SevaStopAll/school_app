package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.school_app.domain.SchoolClass;

import java.util.Set;

@Repository
public interface SchoolClassRepository extends CrudRepository<SchoolClass, Integer> {
    Set<SchoolClass> findAll();
}
