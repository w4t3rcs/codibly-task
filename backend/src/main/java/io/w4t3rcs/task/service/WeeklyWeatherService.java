package io.w4t3rcs.task.service;

import io.w4t3rcs.task.dto.WeeklyWeatherForecastResponse;
import io.w4t3rcs.task.dto.WeeklyWeatherStatisticsResponse;

public interface WeeklyWeatherService {
    WeeklyWeatherForecastResponse getForecast(Double longitude, Double latitude);

    WeeklyWeatherStatisticsResponse getStatistics(Double longitude, Double latitude);
}
