package ru.sevastopall.schoolapp.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevastopall.schoolapp.domain.Role;
import ru.sevastopall.schoolapp.repository.RoleRepository;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class SimpleRoleService implements RoleService {
    private final RoleRepository roles;

    /**
     * Найти роль по учебной имени
     * @param roleName имя роли
     * @return Optional роли.
     */
    @Override
    public Optional<Role> findByName(String roleName) {
        return roles.findByName(roleName);
    }

    /**
     * Получить список ролей
     * @return список ролей.
     */
    @Override
    public Set<Role> findAll() {
        return roles.findAll();
    }

    /**
     * Получить роль по идентификатору
     * @param roleId идентификатор роли
     * @return Optional роли.
     */
    @Override
    public Optional<Role> findById(int roleId) {
        return roles.findById(roleId);
    }


}
