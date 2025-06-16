package io.w4t3rcs.task.controller;

import io.w4t3rcs.task.dto.WeatherForecastRequest;
import io.w4t3rcs.task.dto.WeeklyWeatherForecastResponse;
import io.w4t3rcs.task.service.WeeklyWeatherForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/forecasts")
@RequiredArgsConstructor
public class WeeklyWeatherForecastController {
    private final WeeklyWeatherForecastService weeklyWeatherForecastService;

    @GetMapping("/weekly")
    public ResponseEntity<WeeklyWeatherForecastResponse> getWeeklyForecast(@RequestBody WeatherForecastRequest request) {
        return ResponseEntity.ok(weeklyWeatherForecastService.getWeeklyForecast(request));
    }
}
