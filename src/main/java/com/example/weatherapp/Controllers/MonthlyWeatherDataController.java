package com.example.weatherapp.Controllers;

import com.example.weatherapp.Entity.MonthlyWeatherData.MonthlyWeatherData;
import com.example.weatherapp.Services.MonthlyWeatherDataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/monthly-weather")
public class MonthlyWeatherDataController {
    private final MonthlyWeatherDataService monthlyWeatherDataService;

    public MonthlyWeatherDataController(MonthlyWeatherDataService monthlyWeatherDataService) {
        this.monthlyWeatherDataService = monthlyWeatherDataService;
    }

    @GetMapping
    public List<MonthlyWeatherData> getMonthlyWeatherData(
            @RequestParam Integer cityId,
            @RequestParam Integer startMonth,
            @RequestParam Integer endMonth,
            @RequestParam Integer startYear,
            @RequestParam Integer endYear
    ) {
        return monthlyWeatherDataService.getMonthlyWeatherDataByCityAndDateRange(
                cityId, startMonth, endMonth, startYear, endYear
        );
    }
}
