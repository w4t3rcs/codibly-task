package io.w4t3rcs.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class MeteoDailyWeatherForecastResponse implements Serializable {
    @JsonProperty("time")
    private LocalDate[] dates;
    @JsonProperty("weather_code")
    private Integer[] weatherCodes;
    @JsonProperty("temperature_2m_max")
    private Double[] maxTemperatures;
    @JsonProperty("temperature_2m_min")
    private Double[] minTemperatures;
    @JsonProperty("sunshine_duration")
    private Double[] sunshineDurations;
}
