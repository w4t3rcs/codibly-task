package io.w4t3rcs.task.url;

import io.w4t3rcs.task.component.WeatherUrlBuilder;
import io.w4t3rcs.task.component.impl.WeeklyForecastUrlBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WeeklyForecastUrlBuilderTest {
    private static WeatherUrlBuilder builder;

    @BeforeAll
    static void init() {
        builder = new WeeklyForecastUrlBuilder();
    }

    @ParameterizedTest
    @CsvSource(value = {"2, 4", "-15, 1", "15.3, 6", "0, -24.224"}, delimiterString = ", ")
    void testBuildUrl(Double longitude, Double latitude) {
        String url = builder.buildUrl(longitude, latitude);
        Assertions.assertEquals(WeeklyForecastUrlBuilder.URL_FORMAT.formatted(longitude, latitude), url);
    }
}
