package ru.sevastopall.schoolapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.schoolapp.domain.SchoolDay;
import ru.sevastopall.schoolapp.domain.SchoolWeek;

import java.util.Collection;
import java.util.Optional;
@Repository
public interface SchoolDayRepository extends CrudRepository<SchoolDay, Integer> {
    Collection<SchoolDay> findAll();
    Optional<SchoolDay> findByName(String name);
    Collection<SchoolDay> findByWeek(SchoolWeek week);
}
