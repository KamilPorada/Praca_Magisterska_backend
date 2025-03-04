package com.example.weatherapp.Services;

import com.example.weatherapp.Entity.YearlyWeatherData.YearlyWeatherData;
import com.example.weatherapp.Entity.YearlyWeatherData.YearlyWeatherDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YearlyWeatherDataService {
    private final YearlyWeatherDataRepository yearlyWeatherDataRepository;

    public YearlyWeatherDataService(YearlyWeatherDataRepository yearlyWeatherDataRepository) {
        this.yearlyWeatherDataRepository = yearlyWeatherDataRepository;
    }

    public List<YearlyWeatherData> getYearlyWeatherDataByCityAndYearRange(Integer cityId, Integer startYear, Integer endYear) {
        return yearlyWeatherDataRepository.findByCityIdAndYearBetween(cityId, startYear, endYear);
    }
}
