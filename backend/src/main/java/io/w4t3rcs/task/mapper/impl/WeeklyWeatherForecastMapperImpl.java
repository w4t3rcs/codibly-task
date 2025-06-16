package io.w4t3rcs.task.mapper.impl;

import io.w4t3rcs.task.dto.DailyWeatherForecastResponse;
import io.w4t3rcs.task.dto.MeteoWeeklyWeatherForecastResponse;
import io.w4t3rcs.task.dto.WeeklyWeatherForecastResponse;
import io.w4t3rcs.task.mapper.DailyWeatherForecastMapper;
import io.w4t3rcs.task.mapper.WeeklyWeatherForecastMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WeeklyWeatherForecastMapperImpl implements WeeklyWeatherForecastMapper {
    private final DailyWeatherForecastMapper mapper;

    @Override
    public WeeklyWeatherForecastResponse mapFromMeteoWeatherForecast(MeteoWeeklyWeatherForecastResponse forecast) {
        DailyWeatherForecastResponse[] dailyWeatherForecasts = mapper.mapFromMeteoDailyWeatherForecast(forecast.getDailyForecast());
        return new WeeklyWeatherForecastResponse(dailyWeatherForecasts);
    }
}
