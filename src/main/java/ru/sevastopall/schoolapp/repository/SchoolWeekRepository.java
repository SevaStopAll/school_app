package ru.sevastopall.schoolapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.schoolapp.domain.SchoolWeek;

import java.util.List;

@Repository
public interface SchoolWeekRepository extends CrudRepository<SchoolWeek, Integer> {
    List<SchoolWeek> findAll();
}
