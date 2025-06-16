package io.w4t3rcs.task.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.TimeZone;

@Data
public class WeatherRequest implements Serializable {
    @NotNull
    private Double longitude;
    @NotNull
    private Double latitude;
    @NotNull
    private TimeZone timeZone;
}
