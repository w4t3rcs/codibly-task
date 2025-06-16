package io.w4t3rcs.task.controller;

import io.w4t3rcs.task.dto.WeatherRequest;
import io.w4t3rcs.task.dto.WeeklyWeatherForecastResponse;
import io.w4t3rcs.task.dto.WeeklyWeatherStatisticsResponse;
import io.w4t3rcs.task.service.WeeklyWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weekly")
@RequiredArgsConstructor
public class WeeklyWeatherController {
    private final WeeklyWeatherService weeklyWeatherService;

    @GetMapping("/forecast")
    public ResponseEntity<WeeklyWeatherForecastResponse> getForecast(@RequestBody WeatherRequest request) {
        return ResponseEntity.ok(weeklyWeatherService.getForecast(request));
    }

    @GetMapping("/statistics")
    public ResponseEntity<WeeklyWeatherStatisticsResponse> getStatistics(@RequestBody WeatherRequest request) {
        return ResponseEntity.ok(weeklyWeatherService.getStatistics(request));
    }
}
