package io.w4t3rcs.task.component;

public interface WeatherUrlBuilder {
    String buildUrl(Double longitude, Double latitude);
}
