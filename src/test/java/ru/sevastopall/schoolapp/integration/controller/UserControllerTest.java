package ru.sevastopall.schoolapp.integration.controller;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.sevastopall.schoolapp.integration.IntegrationTestBase;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@AutoConfigureMockMvc
@RequiredArgsConstructor
public class UserControllerTest extends IntegrationTestBase {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenRegisterGet() throws Exception {
        mockMvc.perform(get("/users/register"))
                .andExpect(MockMvcResultMatchers.view().name("users/register"));
    }
}
