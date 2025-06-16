package io.w4t3rcs.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
public class WeeklyWeatherForecastResponse implements Serializable {
    private DailyWeatherForecastResponse[] dailyWeatherForecasts;
}
