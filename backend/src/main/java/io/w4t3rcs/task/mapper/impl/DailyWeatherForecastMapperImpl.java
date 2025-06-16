package io.w4t3rcs.task.mapper.impl;

import io.w4t3rcs.task.dto.DailyWeatherForecastResponse;
import io.w4t3rcs.task.dto.MeteoDailyWeatherForecastResponse;
import io.w4t3rcs.task.mapper.DailyWeatherForecastMapper;
import io.w4t3rcs.task.service.EstimatedEnergyCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class DailyWeatherForecastMapperImpl implements DailyWeatherForecastMapper {
    private final EstimatedEnergyCalculator calculator;

    @Override
    public DailyWeatherForecastResponse[] mapFromMeteoDailyWeatherForecast(MeteoDailyWeatherForecastResponse forecast) {
        return IntStream.range(0, forecast.getDates().length)
                .mapToObj(i -> DailyWeatherForecastResponse.builder()
                        .date(forecast.getDates()[i])
                        .weatherCode(forecast.getWeatherCodes()[i])
                        .maxTemperature(forecast.getMaxTemperatures()[i])
                        .minTemperature(forecast.getMinTemperatures()[i])
                        .estimatedEnergy(calculator.calculateEstimatedEnergy(forecast.getSunshineDurations()[i]))
                        .build())
                .toArray(DailyWeatherForecastResponse[]::new);
    }
}
