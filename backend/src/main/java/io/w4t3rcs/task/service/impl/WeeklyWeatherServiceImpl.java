package io.w4t3rcs.task.service.impl;

import io.w4t3rcs.task.component.UrlBuilder;
import io.w4t3rcs.task.dto.*;
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
    private final UrlBuilder<WeatherRequest> weeklyForecastUrlBuilder;
    private final UrlBuilder<WeatherRequest> weeklyStatisticsUrlBuilder;
    private final WeeklyWeatherForecastMapper forecastMapper;
    private final WeeklyWeatherStatisticsMapper statisticsMapper;

    @Override
    public WeeklyWeatherForecastResponse getForecast(WeatherRequest request) {
        String url = weeklyForecastUrlBuilder.buildUrl(request);
        MeteoWeeklyWeatherForecastResponse response = restClient.get()
                .uri(url)
                .retrieve()
                .body(MeteoWeeklyWeatherForecastResponse.class);
        return forecastMapper.mapFromMeteoWeatherForecast(Objects.requireNonNull(response));
    }

    @Override
    public WeeklyWeatherStatisticsResponse getStatistics(WeatherRequest request) {
        String url = weeklyStatisticsUrlBuilder.buildUrl(request);
        MeteoWeeklyWeatherStatisticsResponse response = restClient.get()
                .uri(url)
                .retrieve()
                .body(MeteoWeeklyWeatherStatisticsResponse.class);
        return statisticsMapper.mapFromMeteoWeeklyWeatherStatistics(Objects.requireNonNull(response));
    }
}
