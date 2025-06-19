package io.w4t3rcs.task.mapper;

import io.w4t3rcs.task.dto.MeteoDailyWeatherStatisticsResponse;
import io.w4t3rcs.task.dto.MeteoWeeklyWeatherStatisticsResponse;
import io.w4t3rcs.task.dto.WeekPrecipitationStatus;
import io.w4t3rcs.task.dto.WeeklyWeatherStatisticsResponse;
import io.w4t3rcs.task.mapper.impl.WeeklyWeatherStatisticsMapperImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class WeeklyWeatherStatisticsMapperTests {
    private static MeteoWeeklyWeatherStatisticsResponse meteoWeeklyStatistics;
    private static WeeklyWeatherStatisticsResponse weeklyStatistics;
    private static WeeklyWeatherStatisticsMapper mapper;

    @BeforeAll
    static void init() {
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
        mapper = new WeeklyWeatherStatisticsMapperImpl();
    }

    @Test
    void testMapToWeeklyWeatherStatisticsResponse() {
        Assertions.assertEquals(weeklyStatistics, mapper.mapFromMeteoWeeklyWeatherStatistics(meteoWeeklyStatistics));
    }
}
