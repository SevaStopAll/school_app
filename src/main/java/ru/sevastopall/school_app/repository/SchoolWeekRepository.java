package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.school_app.domain.SchoolWeek;
@Repository
public interface SchoolWeekRepository extends CrudRepository<SchoolWeek, Integer> {
}
