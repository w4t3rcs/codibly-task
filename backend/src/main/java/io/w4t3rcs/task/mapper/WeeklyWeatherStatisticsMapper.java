package io.w4t3rcs.task.mapper;

import io.w4t3rcs.task.dto.DailyWeatherForecastResponse;
import io.w4t3rcs.task.dto.MeteoDailyWeatherForecastResponse;
import io.w4t3rcs.task.dto.MeteoDailyWeatherStatisticsResponse;

public interface DailyWeatherStatisticsMapper {
    DailyWeatherForecastResponse[] mapFromMeteoDailyWeatherStatistics(MeteoDailyWeatherStatisticsResponse statistics);
}
