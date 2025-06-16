package io.w4t3rcs.task.service;

import io.w4t3rcs.task.dto.WeatherRequest;
import io.w4t3rcs.task.dto.WeeklyWeatherForecastResponse;
import io.w4t3rcs.task.dto.WeeklyWeatherStatisticsResponse;

public interface WeeklyWeatherService {
    WeeklyWeatherForecastResponse getForecast(WeatherRequest request);

    WeeklyWeatherStatisticsResponse getStatistics(WeatherRequest request);
}
