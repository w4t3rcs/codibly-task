package io.w4t3rcs.task.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.w4t3rcs.task.service.EstimatedEnergyCalculator;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeteoWeatherForecastResponse implements Serializable {
    @JsonProperty("daily")
    private MeteoDailyWeatherForecastResponse dailyForecast;
}
