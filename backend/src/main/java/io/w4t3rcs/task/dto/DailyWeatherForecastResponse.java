package io.w4t3rcs.task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
public class DailyWeatherForecastResponse {
    private LocalDate date;
    private Integer weatherCode;
    private Double maxTemperature;
    private Double minTemperature;
    private Double estimatedEnergy;
}
