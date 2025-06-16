package io.w4t3rcs.task.component.impl;

import io.w4t3rcs.task.component.UrlBuilder;
import io.w4t3rcs.task.dto.WeatherForecastResponse;

public class ForecastUrlBuilder implements UrlBuilder<WeatherForecastResponse> {
    @Override
    public String buildUrl(WeatherForecastResponse weatherForecastResponse) {
        return "";
    }
}
