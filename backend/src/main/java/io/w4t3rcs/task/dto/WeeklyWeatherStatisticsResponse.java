package io.w4t3rcs.task.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor
public class WeeklyWeatherStatisticsResponse implements Serializable {
    private Double maxTemperature;
    private Double minTemperature;
    private Double averageSurfacePressure;
    private Double averageSunshineDuration;
    private WeekPrecipitationStatus precipitationStatus;
}
