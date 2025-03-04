package com.example.weatherapp.Controllers;

import com.example.weatherapp.Entity.YearlyWeatherData.YearlyWeatherData;
import com.example.weatherapp.Services.YearlyWeatherDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/yearly-weather")
public class YearlyWeatherDataController {
    private final YearlyWeatherDataService yearlyWeatherDataService;

    public YearlyWeatherDataController(YearlyWeatherDataService yearlyWeatherDataService) {
        this.yearlyWeatherDataService = yearlyWeatherDataService;
    }

    @GetMapping
    public List<YearlyWeatherData> getYearlyWeatherData(
            @RequestParam Integer cityId,
            @RequestParam Integer startYear,
            @RequestParam Integer endYear
    ) {
        return yearlyWeatherDataService.getYearlyWeatherDataByCityAndYearRange(cityId, startYear, endYear);
    }
}
