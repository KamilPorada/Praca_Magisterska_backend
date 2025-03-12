package com.example.weatherapp.Controllers;

import com.example.weatherapp.Services.WeatherStatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class WeatherStatsController {

    private final WeatherStatsService weatherStatsService;

    public WeatherStatsController(WeatherStatsService weatherStatsService) {
        this.weatherStatsService = weatherStatsService;
    }

    @GetMapping("/api/stats-data")
    public Object getWeatherStats(
            @RequestParam Integer cityId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        return weatherStatsService.getWeatherStats(cityId, startDate, endDate);
    }
}
