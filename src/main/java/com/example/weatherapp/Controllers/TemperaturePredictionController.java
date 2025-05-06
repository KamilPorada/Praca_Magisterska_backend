package com.example.weatherapp.Controllers;

import com.example.weatherapp.DTO.TemperaturePredictionDTO;
import com.example.weatherapp.Services.TemperaturePredictionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/temperature-prediction")
public class TemperaturePredictionController {

    private final TemperaturePredictionService temperaturePredictionService;

    public TemperaturePredictionController(TemperaturePredictionService temperaturePredictionService) {
        this.temperaturePredictionService = temperaturePredictionService;
    }

    @GetMapping
    public List<TemperaturePredictionDTO> getAllTemperatureData(@RequestParam Integer cityId) {
        return temperaturePredictionService.getTemperatureDataForCity(cityId);
    }
}
