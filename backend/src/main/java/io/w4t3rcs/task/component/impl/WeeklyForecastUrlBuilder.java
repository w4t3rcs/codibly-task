package io.w4t3rcs.task.component.impl;

import io.w4t3rcs.task.component.UrlBuilder;
import io.w4t3rcs.task.dto.WeatherRequest;
import org.springframework.stereotype.Component;

@Component
public class WeeklyForecastUrlBuilder implements UrlBuilder<WeatherRequest> {
    public static final String URL_FORMAT = "/forecast?latitude=%f&longitude=%f&daily=weather_code,temperature_2m_max,temperature_2m_min,sunshine_duration&timezone=%s";

    @Override
    public String buildUrl(WeatherRequest request) {
        return URL_FORMAT.formatted(request.getLatitude(), request.getLongitude(), request.getTimeZone());
    }
}
