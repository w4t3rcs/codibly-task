package io.w4t3rcs.task.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WeeklyWeatherControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetForecast() throws Exception {
        mockMvc.perform(get("/api/v1/weather/forecast")
                        .param("longitude", "25.4")
                        .param("latitude", "36")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testInvalidGetForecast() throws Exception {
        mockMvc.perform(get("/api/v1/weather/forecast")
                        .param("longitude", "215.4")
                        .param("latitude", "364")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testGetStatistics() throws Exception {
        mockMvc.perform(get("/api/v1/weather/statistics")
                        .param("longitude", "25.4")
                        .param("latitude", "36")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void testInvalidGetStatistics() throws Exception {
        mockMvc.perform(get("/api/v1/weather/statistics")
                        .param("longitude", "215.4")
                        .param("latitude", "364")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
