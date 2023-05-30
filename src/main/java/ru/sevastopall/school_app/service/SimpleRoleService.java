package ru.sevastopall.school_app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.school_app.domain.Role;
import ru.sevastopall.school_app.repository.RoleRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SimpleRoleService implements RoleService {
    private final RoleRepository roles;

    @Override
    public Optional<Role> findByName(String roleName) {
        return roles.findByName(roleName);
    }

    @Override
    public Set<Role> findAll() {
        return roles.findAll();
    }

    @Override
    public Optional<Role> findById(int roleId) {
        return roles.findById(roleId);
    }


}
