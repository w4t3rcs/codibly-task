package io.w4t3rcs.task.component.impl;

import io.w4t3rcs.task.component.WeatherUrlBuilder;
import org.springframework.stereotype.Component;

@Component
public class WeeklyStatisticsUrlBuilder implements WeatherUrlBuilder {
    public static final String URL_FORMAT = "/forecast?longitude=%s&latitude=%s&daily=temperature_2m_max,temperature_2m_min,sunshine_duration,surface_pressure_mean,precipitation_sum&past_days=7&forecast_days=0";

    @Override
    public String buildUrl(Double longitude, Double latitude) {
        String longitudeString = longitude.toString().replace(",", ".");
        String latitudeString = latitude.toString().replace(",", ".");
        return URL_FORMAT.formatted(longitudeString, latitudeString);
    }
}
