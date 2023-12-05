package ru.sevastopall.schoolapp.integration;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import ru.sevastopall.schoolapp.annotation.IT;
import ru.sevastopall.schoolapp.domain.User;

@IT
@Sql({
        "classpath:sql/data.sql"
})
public abstract class IntegrationTestBase {
    private static final PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:14.1");

    @BeforeAll
    static void runContainer() {
        container.start();
    }

    @DynamicPropertySource
    static void postgresProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
    }

    //TODO create init methods
    public static User initUser() {
        User user = new User();
        user.setConfirmed(true);
        user.setEmail("test@test.ru");
        user.setFirstName("test");
        user.setLastName("test");
        user.setLogin("test");
        user.setPassword("test");
        user.setRoles();
    }
}
