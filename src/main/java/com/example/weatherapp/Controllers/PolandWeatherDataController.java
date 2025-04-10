package com.example.weatherapp.Controllers;

import com.example.weatherapp.DTO.PolandWeatherDataDTO;
import com.example.weatherapp.Services.PolandWeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/poland-weather")
@CrossOrigin
public class PolandWeatherDataController {

    private final PolandWeatherDataService weatherDataService;

    @Autowired
    public PolandWeatherDataController(PolandWeatherDataService weatherDataService) {
        this.weatherDataService = weatherDataService;
    }

    @GetMapping
    public List<PolandWeatherDataDTO> getWeatherDataForDate(
            @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
    ) {
        return weatherDataService.getWeatherDataForDate(date);
    }
}
