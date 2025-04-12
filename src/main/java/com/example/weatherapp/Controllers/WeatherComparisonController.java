package com.example.weatherapp.Controllers;

import com.example.weatherapp.DTO.WeatherComparisonDTO;
import com.example.weatherapp.Services.WeatherComparisonService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/compare")
public class WeatherComparisonController {

    private final WeatherComparisonService service;

    public WeatherComparisonController(WeatherComparisonService service) {
        this.service = service;
    }

    @GetMapping
    public WeatherComparisonDTO compareCities(
            @RequestParam Integer cityId1,
            @RequestParam Integer cityId2,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return service.compareCities(cityId1, cityId2, date);
    }
}
