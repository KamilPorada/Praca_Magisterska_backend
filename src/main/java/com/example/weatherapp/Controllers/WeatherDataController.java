package com.example.weatherapp.Controllers;

import com.example.weatherapp.Entity.WeatherData.WeatherData;
import com.example.weatherapp.Services.WeatherDataService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherDataController {
    private final WeatherDataService weatherDataService;

    public WeatherDataController(WeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    @GetMapping
    public List<WeatherData> getWeatherData(
            @RequestParam Integer cityId,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        return weatherDataService.getWeatherDataByCityAndDateRange(cityId, startDate, endDate);
    }
}
