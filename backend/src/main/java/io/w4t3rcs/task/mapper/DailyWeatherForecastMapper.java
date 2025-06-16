package io.w4t3rcs.task.mapper;

import io.w4t3rcs.task.dto.DailyWeatherForecastResponse;
import io.w4t3rcs.task.dto.MeteoDailyWeatherForecastResponse;

public interface DailyWeatherForecastMapper {
    DailyWeatherForecastResponse[] mapFromMeteoDailyWeatherForecast(MeteoDailyWeatherForecastResponse forecast);
}
