package ru.sevastopall.schoolapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sevastopall.schoolapp.domain.Role;


import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Set<Role> findAll();
    Optional<Role> findByName(String roleName);
    Optional<Role> findById(int roleId);
}
