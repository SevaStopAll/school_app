package ru.sevastopall.school_app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.school_app.domain.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
