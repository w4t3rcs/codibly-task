package io.w4t3rcs.task.service;

import io.w4t3rcs.task.dto.WeatherForecastRequest;
import io.w4t3rcs.task.dto.WeeklyWeatherForecastResponse;

public interface WeeklyWeatherForecastService {
    WeeklyWeatherForecastResponse getWeeklyForecast(WeatherForecastRequest request);
}
