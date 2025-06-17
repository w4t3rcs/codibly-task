package io.w4t3rcs.task.controller;

import io.w4t3rcs.task.dto.WeeklyWeatherForecastResponse;
import io.w4t3rcs.task.dto.WeeklyWeatherStatisticsResponse;
import io.w4t3rcs.task.service.WeeklyWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/weather")
@RequiredArgsConstructor
public class WeeklyWeatherController {
    private final WeeklyWeatherService weeklyWeatherService;

    @GetMapping(value = "/forecast", params = {"longitude", "latitude"})
    public ResponseEntity<WeeklyWeatherForecastResponse> getForecast(@RequestParam Double longitude, @RequestParam Double latitude) {
        return ResponseEntity.ok(weeklyWeatherService.getForecast(longitude, latitude));
    }

    @GetMapping(value = "/statistics", params = {"longitude", "latitude"})
    public ResponseEntity<WeeklyWeatherStatisticsResponse> getStatistics(@RequestParam Double longitude, @RequestParam Double latitude) {
        return ResponseEntity.ok(weeklyWeatherService.getStatistics(longitude, latitude));
    }
}
