package io.w4t3rcs.task.mapper;

import io.w4t3rcs.task.dto.MeteoWeeklyWeatherForecastResponse;
import io.w4t3rcs.task.dto.WeeklyWeatherForecastResponse;

public interface WeeklyWeatherForecastMapper {
    WeeklyWeatherForecastResponse mapFromMeteoWeatherForecast(MeteoWeeklyWeatherForecastResponse forecast);
}
