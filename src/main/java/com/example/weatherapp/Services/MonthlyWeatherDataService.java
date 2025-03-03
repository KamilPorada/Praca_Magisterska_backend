package com.example.weatherapp.Services;

import com.example.weatherapp.Entity.MonthlyWeatherData.MonthlyWeatherData;
import com.example.weatherapp.Entity.MonthlyWeatherData.MonthlyWeatherDataRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonthlyWeatherDataService {
    private final MonthlyWeatherDataRepository monthlyWeatherDataRepository;

    public MonthlyWeatherDataService(MonthlyWeatherDataRepository monthlyWeatherDataRepository) {
        this.monthlyWeatherDataRepository = monthlyWeatherDataRepository;
    }

    public List<MonthlyWeatherData> getMonthlyWeatherDataByCityAndDateRange(
            Integer cityId, Integer startMonth, Integer endMonth, Integer startYear, Integer endYear
    ) {
        List<MonthlyWeatherData> data = monthlyWeatherDataRepository.findByCityIdAndYearBetween(
                cityId, startYear, endYear
        );

        return data.stream()
                .filter(entry ->
                        (entry.getYear().equals(startYear) && entry.getMonth() >= startMonth) ||
                                (entry.getYear().equals(endYear) && entry.getMonth() <= endMonth) ||
                                (entry.getYear() > startYear && entry.getYear() < endYear)
                )
                .collect(Collectors.toList());
    }
}
