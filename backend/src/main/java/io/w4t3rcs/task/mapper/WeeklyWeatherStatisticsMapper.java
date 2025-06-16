package io.w4t3rcs.task.mapper;

import io.w4t3rcs.task.dto.MeteoWeeklyWeatherStatisticsResponse;
import io.w4t3rcs.task.dto.WeeklyWeatherStatisticsResponse;

public interface WeeklyWeatherStatisticsMapper {
    WeeklyWeatherStatisticsResponse mapFromMeteoWeeklyWeatherStatistics(MeteoWeeklyWeatherStatisticsResponse statistics);
}
