package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.school_app.domain.ClassDay;
import ru.sevastopall.school_app.domain.SchoolClass;
import ru.sevastopall.school_app.domain.SchoolDay;

import java.util.Collection;

@Repository
public interface ClassDayRepository extends CrudRepository<ClassDay, Integer> {
    Collection<ClassDay> findAll();

    Collection<ClassDay> findBySchoolClass(SchoolClass schoolClass);

    Collection<ClassDay> findBySchoolDay(SchoolDay schoolDay);
}
