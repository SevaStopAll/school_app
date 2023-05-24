package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.school_app.domain.SchoolDay;

import java.util.Collection;
import java.util.Optional;
@Repository
public interface SchoolDayRepository extends CrudRepository<SchoolDay, Integer> {

    Collection<SchoolDay> findAll();

    Optional<SchoolDay> findByName(String name);
}
