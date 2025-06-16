package io.w4t3rcs.task.mapper.impl;

import io.w4t3rcs.task.dto.MeteoDailyWeatherStatisticsResponse;
import io.w4t3rcs.task.dto.MeteoWeeklyWeatherStatisticsResponse;
import io.w4t3rcs.task.dto.WeekPrecipitationStatus;
import io.w4t3rcs.task.dto.WeeklyWeatherStatisticsResponse;
import io.w4t3rcs.task.mapper.WeeklyWeatherStatisticsMapper;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class WeeklyWeatherStatisticsMapperImpl implements WeeklyWeatherStatisticsMapper {
    public static final int WEEK_HALF = 4;

    @Override
    public WeeklyWeatherStatisticsResponse mapFromMeteoWeeklyWeatherStatistics(MeteoWeeklyWeatherStatisticsResponse statistics) {
        MeteoDailyWeatherStatisticsResponse dailyStatistics = statistics.getDailyStatistics();
        Double maxTemperature = Arrays.stream(dailyStatistics.getMaxTemperatures())
                .max(Double::compareTo)
                .orElse(0D);
        Double minTemperature = Arrays.stream(dailyStatistics.getMinTemperatures())
                .min(Double::compareTo)
                .orElse(0D);
        Double averageSurfacePressure = Arrays.stream(dailyStatistics.getAverageSurfacePressures())
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0D);
        Double averageSunshineDuration = Arrays.stream(dailyStatistics.getSunshineDurations())
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0D);
        long precipitationCount = Arrays.stream(dailyStatistics.getPrecipitationSums())
                .filter(d -> d == 0)
                .count();
        WeekPrecipitationStatus precipitationStatus = precipitationCount < WEEK_HALF
                ? WeekPrecipitationStatus.WITHOUT_PRECIPITATION
                : WeekPrecipitationStatus.WITH_PRECIPITATION;
        return new WeeklyWeatherStatisticsResponse(maxTemperature, minTemperature, averageSurfacePressure, averageSunshineDuration, precipitationStatus);
    }
}
