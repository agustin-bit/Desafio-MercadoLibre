package meli.challenge.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import meli.challenge.demo.service.StatsService;
import meli.challenge.demo.service.impl.StatsServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StatsController.class)
class StatsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StatsServiceImpl statsService;

    @Test
    void findStats() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/stats")
                .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().is(200));

    }
}