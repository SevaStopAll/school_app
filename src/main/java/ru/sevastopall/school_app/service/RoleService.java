package ru.sevastopall.school_app.service;

import ru.sevastopall.school_app.domain.Role;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleService {

    Optional<Role> findByName(String roleName);

    Set<Role> findAll();

    Optional<Role> findById(int roleId);

}
