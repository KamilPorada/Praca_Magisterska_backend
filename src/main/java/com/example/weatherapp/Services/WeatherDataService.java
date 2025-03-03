package com.example.weatherapp.Services;

import com.example.weatherapp.Entity.WeatherData.WeatherData;
import com.example.weatherapp.Entity.WeatherData.WeatherDataRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class WeatherDataService {
    private final WeatherDataRepository weatherDataRepository;

    public WeatherDataService(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    public List<WeatherData> getWeatherDataByCityAndDateRange(Integer cityId, LocalDate startDate, LocalDate endDate) {
        return weatherDataRepository.findByCityIdAndDateBetween(cityId, startDate, endDate);
    }
}
