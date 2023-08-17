package ru.sevastopall.schoolapp.controller;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.sevastopall.schoolapp.IntegrationTestBase;

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
