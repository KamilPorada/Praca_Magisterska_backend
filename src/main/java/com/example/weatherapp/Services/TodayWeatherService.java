package com.example.weatherapp.Services;

import com.example.weatherapp.Entity.TodayWeather.TodayWeather;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Locale;

@Service
public class TodayWeatherService {
    private final RestTemplate restTemplate = new RestTemplate();

    public TodayWeather getWeather(double latitude, double longitude) {
        String url = String.format(Locale.US,
                "https://api.open-meteo.com/v1/forecast?latitude=%.6f&longitude=%.6f&current=temperature_2m,relative_humidity_2m,is_day,weather_code,surface_pressure,wind_speed_10m&daily=sunrise,sunset&timezone=auto&forecast_days=2",
                latitude, longitude);
        return restTemplate.getForObject(url, TodayWeather.class);
    }
}
