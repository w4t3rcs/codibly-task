package io.w4t3rcs.task.mapper;

import io.w4t3rcs.task.dto.DailyWeatherForecastResponse;
import io.w4t3rcs.task.dto.MeteoDailyWeatherForecastResponse;
import io.w4t3rcs.task.mapper.impl.DailyWeatherForecastMapperImpl;
import io.w4t3rcs.task.service.EstimatedEnergyCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class DailyWeatherForecastMapperTests {
    private static MeteoDailyWeatherForecastResponse meteoDailyForecast;
    private static DailyWeatherForecastResponse[] dailyForecast;
    @Mock
    private EstimatedEnergyCalculator calculator;
    @InjectMocks
    private DailyWeatherForecastMapperImpl mapper;

    @BeforeAll
    static void init() {
        meteoDailyForecast = MeteoDailyWeatherForecastResponse.builder()
                .dates(new LocalDate[]{LocalDate.now(), LocalDate.now().plusDays(1), LocalDate.now().plusDays(2)})
                .weatherCodes(new Integer[]{0, 61, 99})
                .maxTemperatures(new Double[]{15D, 12.4D, 18.03D})
                .minTemperatures(new Double[]{6D, -0.8D, -183D})
                .sunshineDurations(new Double[]{0D, 0D, 0D})
                .build();
        dailyForecast = new DailyWeatherForecastResponse[]{
                new DailyWeatherForecastResponse(LocalDate.now(), 0, 15D, 6D, 52D),
                new DailyWeatherForecastResponse(LocalDate.now().plusDays(1), 61, 12.4D, -0.8D, 52D),
                new DailyWeatherForecastResponse(LocalDate.now().plusDays(2), 99, 18.03D, -183D, 52D)
        };
    }

    @Test
    void testMapToWeeklyWeatherStatisticsResponse() {
        Mockito.when(calculator.calculateEstimatedEnergy(0D)).thenReturn(52D);
        Assertions.assertArrayEquals(dailyForecast, mapper.mapFromMeteoDailyWeatherForecast(meteoDailyForecast));
    }
}
