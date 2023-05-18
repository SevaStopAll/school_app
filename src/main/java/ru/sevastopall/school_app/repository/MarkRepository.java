package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.school_app.domain.Mark;

@Repository
public interface MarkRepository extends CrudRepository<Mark, Integer> {
}
