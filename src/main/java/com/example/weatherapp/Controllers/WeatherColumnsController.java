package com.example.weatherapp.Controllers;

import com.example.weatherapp.DTO.WeatherColumnResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/weather")
public class WeatherColumnsController {

    @GetMapping("/columns")
    public WeatherColumnResponse getWeatherDataColumns() {
        List<String> columns = List.of(
                "maxTemperature",
                "minTemperature",
                "maxFeelTemperature",
                "minFeelTemperature",
                "totalPrecipitation",
                "rain",
                "rainSnow",
                "snow",
                "precipitationDuration",
                "weatherCode",
                "sunlightDuration",
                "daylightDuration",
                "maxWindSpeed",
                "windGusts",
                "dominantWindDirection",
                "totalSolarRadiation",
                "evapotranspiration"
        );

        return new WeatherColumnResponse(columns);
    }
}
