package io.w4t3rcs.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class MeteoDailyWeatherStatisticsResponse implements Serializable {
    @JsonProperty("time")
    private LocalDate[] dates;
    @JsonProperty("temperature_2m_max")
    private Double[] maxTemperatures;
    @JsonProperty("temperature_2m_min")
    private Double[] minTemperatures;
    @JsonProperty("sunshine_duration")
    private Double[] sunshineDurations;
    @JsonProperty("surface_pressure_mean")
    private Double[] averageSurfacePressures;
    @JsonProperty("precipitation_sum")
    private Double[] precipitationSums;
}
