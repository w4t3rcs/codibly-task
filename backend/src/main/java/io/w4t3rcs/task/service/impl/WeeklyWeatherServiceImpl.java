package io.w4t3rcs.task.service.impl;

import io.w4t3rcs.task.component.WeatherUrlBuilder;
import io.w4t3rcs.task.dto.MeteoWeeklyWeatherForecastResponse;
import io.w4t3rcs.task.dto.MeteoWeeklyWeatherStatisticsResponse;
import io.w4t3rcs.task.dto.WeeklyWeatherForecastResponse;
import io.w4t3rcs.task.dto.WeeklyWeatherStatisticsResponse;
import io.w4t3rcs.task.mapper.WeeklyWeatherForecastMapper;
import io.w4t3rcs.task.mapper.WeeklyWeatherStatisticsMapper;
import io.w4t3rcs.task.service.WeeklyWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class WeeklyWeatherServiceImpl implements WeeklyWeatherService {
    private final RestClient restClient;
    private final WeatherUrlBuilder weeklyForecastUrlBuilder;
    private final WeatherUrlBuilder weeklyStatisticsUrlBuilder;
    private final WeeklyWeatherForecastMapper forecastMapper;
    private final WeeklyWeatherStatisticsMapper statisticsMapper;

    @Override
    public WeeklyWeatherForecastResponse getForecast(Double longitude, Double latitude) {
        if (latitude < -90 || latitude > 90) throw new IllegalArgumentException("Latitude must be between -90 and 90.");
        String url = weeklyForecastUrlBuilder.buildUrl(longitude, latitude);
        MeteoWeeklyWeatherForecastResponse response = restClient.get()
                .uri(url)
                .retrieve()
                .body(MeteoWeeklyWeatherForecastResponse.class);
        return forecastMapper.mapFromMeteoWeatherForecast(Objects.requireNonNull(response));
    }

    @Override
    public WeeklyWeatherStatisticsResponse getStatistics(Double longitude, Double latitude) {
        if (latitude < -90 || latitude > 90) throw new IllegalArgumentException("Latitude must be between -90 and 90.");
        String url = weeklyStatisticsUrlBuilder.buildUrl(longitude, latitude);
        MeteoWeeklyWeatherStatisticsResponse response = restClient.get()
                .uri(url)
                .retrieve()
                .body(MeteoWeeklyWeatherStatisticsResponse.class);
        return statisticsMapper.mapFromMeteoWeeklyWeatherStatistics(Objects.requireNonNull(response));
    }
}
