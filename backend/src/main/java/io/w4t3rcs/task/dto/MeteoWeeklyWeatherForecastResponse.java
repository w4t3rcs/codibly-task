package io.w4t3rcs.task.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor @NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MeteoWeeklyWeatherForecastResponse implements Serializable {
    @JsonProperty("daily")
    private MeteoDailyWeatherForecastResponse dailyForecast;
}
