package ru.sevastopall.schoolapp.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sevastopall.schoolapp.integration.IntegrationTestBase;
import ru.sevastopall.schoolapp.repository.RoleRepository;
import ru.sevastopall.schoolapp.service.SimpleRoleService;


@RequiredArgsConstructor
class SimpleRoleServiceTest extends IntegrationTestBase {
    RoleRepository roleRepository;

    @Autowired
    private final SimpleRoleService simpleRoleService = new SimpleRoleService(roleRepository);

    @Test
    void test() {
        System.out.println("test");
    }

}