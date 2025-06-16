package io.w4t3rcs.task.service.impl;

import io.w4t3rcs.task.component.UrlBuilder;
import io.w4t3rcs.task.dto.MeteoWeatherForecastResponse;
import io.w4t3rcs.task.dto.WeatherForecastRequest;
import io.w4t3rcs.task.dto.WeeklyWeatherForecastResponse;
import io.w4t3rcs.task.mapper.WeeklyWeatherForecastMapper;
import io.w4t3rcs.task.service.WeeklyWeatherForecastService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class WeeklyWeatherForecastServiceImpl implements WeeklyWeatherForecastService {
    //https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&daily=weather_code,temperature_2m_max,temperature_2m_min,sunshine_duration&timezone=Europe%2FLondon
    private final RestClient restClient;
    private final UrlBuilder<WeatherForecastRequest> weeklyForecastUrlBuilder;
    private final WeeklyWeatherForecastMapper mapper;

    @Override
    public WeeklyWeatherForecastResponse getWeeklyForecast(WeatherForecastRequest request) {
        String url = weeklyForecastUrlBuilder.buildUrl(request);
        MeteoWeatherForecastResponse response = restClient.get()
                .uri(url)
                .retrieve()
                .body(MeteoWeatherForecastResponse.class);
        return mapper.mapFromMeteoWeatherForecast(Objects.requireNonNull(response));
    }
}
