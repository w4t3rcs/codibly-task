package io.w4t3rcs.task.mapper;

import io.w4t3rcs.task.dto.DailyWeatherForecastResponse;
import io.w4t3rcs.task.dto.MeteoDailyWeatherForecastResponse;
import io.w4t3rcs.task.dto.MeteoWeeklyWeatherForecastResponse;
import io.w4t3rcs.task.dto.WeeklyWeatherForecastResponse;
import io.w4t3rcs.task.mapper.impl.WeeklyWeatherForecastMapperImpl;
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
public class WeeklyWeatherForecastMapperTests {
    private static MeteoDailyWeatherForecastResponse meteoDailyForecast;
    private static MeteoWeeklyWeatherForecastResponse meteoWeeklyForecast;
    private static DailyWeatherForecastResponse[] dailyForecast;
    private static WeeklyWeatherForecastResponse weeklyForecast;
    @Mock
    private DailyWeatherForecastMapper dailyMapper;
    @InjectMocks
    private WeeklyWeatherForecastMapperImpl weeklyMapper;

    @BeforeAll
    static void init() {
        meteoDailyForecast = MeteoDailyWeatherForecastResponse.builder()
                .dates(new LocalDate[]{LocalDate.now(), LocalDate.now().plusDays(1), LocalDate.now().plusDays(2)})
                .weatherCodes(new Integer[]{0, 61, 99})
                .maxTemperatures(new Double[]{15D, 12.4D, 18.03D})
                .minTemperatures(new Double[]{6D, -0.8D, -183D})
                .sunshineDurations(new Double[]{13515.8D, 166854.24D, 97457D})
                .build();
        meteoWeeklyForecast = new MeteoWeeklyWeatherForecastResponse(meteoDailyForecast);
        dailyForecast = new DailyWeatherForecastResponse[]{
                new DailyWeatherForecastResponse(LocalDate.now(), 0, 15D, 6D, 0D),
                new DailyWeatherForecastResponse(LocalDate.now().plusDays(1), 61, 12.4D, -0.8D, 0D),
                new DailyWeatherForecastResponse(LocalDate.now().plusDays(2), 99, 18.03D, -183D, 0D)
        };
        weeklyForecast = new WeeklyWeatherForecastResponse(dailyForecast);
    }

    @Test
    void testMapToWeeklyWeatherStatisticsResponse() {
        Mockito.when(dailyMapper.mapFromMeteoDailyWeatherForecast(meteoDailyForecast)).thenReturn(dailyForecast);
        Assertions.assertEquals(weeklyForecast, weeklyMapper.mapFromMeteoWeatherForecast(meteoWeeklyForecast));
    }
}
