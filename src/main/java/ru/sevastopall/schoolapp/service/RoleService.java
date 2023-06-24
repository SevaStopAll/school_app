package ru.sevastopall.schoolapp.service;

import ru.sevastopall.schoolapp.domain.Role;

import java.util.Optional;
import java.util.Set;

public interface RoleService {
    Optional<Role> findByName(String roleName);
    Set<Role> findAll();
    Optional<Role> findById(int roleId);

}
