package com.example.weatherapp.Controllers;


import com.example.weatherapp.Entity.TodayWeather.TodayWeather;
import com.example.weatherapp.Services.TodayWeatherService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/today-weather")
@CrossOrigin(origins = "*") // Jeśli masz frontend na innym porcie, np. React
public class TodayWeatherController {
    private final TodayWeatherService weatherService;

    public TodayWeatherController(TodayWeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping
    public TodayWeather getWeather(
            @RequestParam double latitude,
            @RequestParam double longitude) {
        return weatherService.getWeather(latitude, longitude);
    }
}
