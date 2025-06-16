package io.w4t3rcs.task.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.TimeZone;

@Data
public class WeatherForecastRequest implements Serializable {
    @NotNull
    private Float longitude;
    @NotNull
    private Float latitude;
    @NotNull
    private TimeZone timeZone;
}
