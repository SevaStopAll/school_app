package ru.sevastopall.schoolapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.schoolapp.domain.SchoolClass;

import java.util.Set;

@Repository
public interface SchoolClassRepository extends CrudRepository<SchoolClass, Integer> {
    Set<SchoolClass> findAll();
}
