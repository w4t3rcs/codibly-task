package io.w4t3rcs.task.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class WebConfig {
    //https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&daily=weather_code,temperature_2m_max,temperature_2m_min,sunshine_duration&timezone=Europe%2FLondon
    public static final String METEO_API_URL = "https://api.open-meteo.com/v1";

    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder.baseUrl(METEO_API_URL).build();
    }
}
