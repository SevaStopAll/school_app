package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sevastopall.school_app.domain.SchoolWeek;

public interface SchoolWeekRepository extends CrudRepository<SchoolWeek, Integer> {
}
