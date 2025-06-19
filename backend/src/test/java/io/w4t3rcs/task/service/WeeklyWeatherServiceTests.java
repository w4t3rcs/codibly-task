package io.w4t3rcs.task.service;

import io.w4t3rcs.task.component.WeatherUrlBuilder;
import io.w4t3rcs.task.dto.*;
import io.w4t3rcs.task.mapper.WeeklyWeatherForecastMapper;
import io.w4t3rcs.task.mapper.WeeklyWeatherStatisticsMapper;
import io.w4t3rcs.task.service.impl.WeeklyWeatherServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestClient;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class WeeklyWeatherServiceTests {
    private static MeteoWeeklyWeatherForecastResponse meteoWeeklyForecast;
    private static WeeklyWeatherForecastResponse weeklyForecast;
    private static MeteoWeeklyWeatherStatisticsResponse meteoWeeklyStatistics;
    private static WeeklyWeatherStatisticsResponse weeklyStatistics;
    @Mock
    private RestClient restClient;
    @Mock
    private WeatherUrlBuilder weeklyForecastUrlBuilder;
    @Mock
    private WeatherUrlBuilder weeklyStatisticsUrlBuilder;
    @Mock
    private WeeklyWeatherForecastMapper forecastMapper;
    @Mock
    private WeeklyWeatherStatisticsMapper statisticsMapper;
    @InjectMocks
    private WeeklyWeatherServiceImpl weeklyWeatherService;

    @BeforeAll
    static void init() {
        var meteoDailyForecast = MeteoDailyWeatherForecastResponse.builder()
                .dates(new LocalDate[]{LocalDate.now(), LocalDate.now().plusDays(1), LocalDate.now().plusDays(2)})
                .weatherCodes(new Integer[]{0, 61, 99})
                .maxTemperatures(new Double[]{15D, 12.4D, 18.03D})
                .minTemperatures(new Double[]{6D, -0.8D, -183D})
                .sunshineDurations(new Double[]{13515.8D, 166854.24D, 97457D})
                .build();
        meteoWeeklyForecast = new MeteoWeeklyWeatherForecastResponse(meteoDailyForecast);
        var dailyForecast = new DailyWeatherForecastResponse[]{
                new DailyWeatherForecastResponse(LocalDate.now(), 0, 15D, 6D, 0D),
                new DailyWeatherForecastResponse(LocalDate.now().plusDays(1), 61, 12.4D, -0.8D, 0D),
                new DailyWeatherForecastResponse(LocalDate.now().plusDays(2), 99, 18.03D, -183D, 0D)
        };
        weeklyForecast = new WeeklyWeatherForecastResponse(dailyForecast);
        var meteoDailyStatistics = MeteoDailyWeatherStatisticsResponse.builder()
                .dates(new LocalDate[]{LocalDate.now(), LocalDate.now().plusDays(1), LocalDate.now().plusDays(2)})
                .weatherCodes(new Integer[]{0, 61, 99, 61, 99, 61, 99})
                .minTemperatures(new Double[]{-10.23D, 0D, 1.3D})
                .maxTemperatures(new Double[]{10.23D, 7D, 3.4D})
                .sunshineDurations(new Double[]{12002D, 66333D, 46325D})
                .averageSurfacePressures(new Double[]{1002D, 2373D, 425D})
                .build();
        meteoWeeklyStatistics = new MeteoWeeklyWeatherStatisticsResponse(meteoDailyStatistics);
        weeklyStatistics = WeeklyWeatherStatisticsResponse.builder()
                .maxTemperature(10.23D)
                .minTemperature(-10.23D)
                .averageSunshineDuration((12002D + 66333D + 46325D) / 3)
                .averageSurfacePressure((1002D + 2373D + 425D) / 3)
                .precipitationStatus(WeekPrecipitationStatus.WITH_PRECIPITATION)
                .build();
    }

    @Test
    void testGetForecast() {
        var uriSpec = Mockito.mock(RestClient.RequestHeadersUriSpec.class);
        var headerSpec = Mockito.mock(RestClient.RequestHeadersSpec.class);
        var responseSpec = Mockito.mock(RestClient.ResponseSpec.class);
        Mockito.when(weeklyForecastUrlBuilder.buildUrl(0D, 0D)).thenReturn("");
        Mockito.when(restClient.get()).then((o) -> uriSpec);
        Mockito.when(uriSpec.uri("")).then((o) -> headerSpec);
        Mockito.when(headerSpec.retrieve()).thenReturn(responseSpec);
        Mockito.when(responseSpec.body(MeteoWeeklyWeatherForecastResponse.class)).thenReturn(meteoWeeklyForecast);
        Mockito.when(forecastMapper.mapFromMeteoWeatherForecast(meteoWeeklyForecast)).thenReturn(weeklyForecast);
        Assertions.assertEquals(weeklyForecast, weeklyWeatherService.getForecast(0D, 0D));
    }

    @Test
    void testGetStatistics() {
        var uriSpec = Mockito.mock(RestClient.RequestHeadersUriSpec.class);
        var headerSpec = Mockito.mock(RestClient.RequestHeadersSpec.class);
        var responseSpec = Mockito.mock(RestClient.ResponseSpec.class);
        Mockito.when(weeklyStatisticsUrlBuilder.buildUrl(0D, 0D)).thenReturn("");
        Mockito.when(restClient.get()).then((o) -> uriSpec);
        Mockito.when(uriSpec.uri("")).then((o) -> headerSpec);
        Mockito.when(headerSpec.retrieve()).thenReturn(responseSpec);
        Mockito.when(responseSpec.body(MeteoWeeklyWeatherStatisticsResponse.class)).thenReturn(meteoWeeklyStatistics);
        Mockito.when(statisticsMapper.mapFromMeteoWeeklyWeatherStatistics(meteoWeeklyStatistics)).thenReturn(weeklyStatistics);
        Assertions.assertEquals(weeklyStatistics, weeklyWeatherService.getStatistics(0D, 0D));
    }
}
