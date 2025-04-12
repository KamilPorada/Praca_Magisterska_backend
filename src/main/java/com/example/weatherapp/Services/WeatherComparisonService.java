package com.example.weatherapp.Services;

import com.example.weatherapp.DTO.WeatherComparisonDTO;
import com.example.weatherapp.Entity.City.City;
import com.example.weatherapp.Entity.WeatherData.WeatherData;
import com.example.weatherapp.Entity.WeatherData.WeatherDataRepository;
import com.example.weatherapp.Entity.City.CityRepository;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Service
public class WeatherComparisonService {

    private final WeatherDataRepository weatherRepo;
    private final CityRepository cityRepo;

    public WeatherComparisonService(WeatherDataRepository weatherRepo, CityRepository cityRepo) {
        this.weatherRepo = weatherRepo;
        this.cityRepo = cityRepo;
    }

    public WeatherComparisonDTO compareCities(Integer cityId1, Integer cityId2, LocalDate date) {
        City city1 = cityRepo.findById(cityId1).orElseThrow();
        City city2 = cityRepo.findById(cityId2).orElseThrow();

        WeatherData data1 = weatherRepo.findByCityIdAndDate(cityId1, date).stream().findFirst().orElseThrow();
        WeatherData data2 = weatherRepo.findByCityIdAndDate(cityId2, date).stream().findFirst().orElseThrow();

        Map<String, WeatherComparisonDTO.ComparisonResult> comparison = new HashMap<>();

        for (Method method : WeatherData.class.getDeclaredMethods()) {
            if (method.getName().startsWith("get") &&
                    method.getReturnType().equals(Double.class)) {
                try {
                    String fieldName = method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
                    Double value1 = (Double) method.invoke(data1);
                    Double value2 = (Double) method.invoke(data2);
                    if (value1 != null && value2 != null) {
                        double diff = Math.abs(value1 - value2);
                        String larger = value1 > value2 ? city1.getName() : city2.getName();
                        comparison.put(fieldName, new WeatherComparisonDTO.ComparisonResult(larger, diff));
                    }
                } catch (Exception e) {
                    e.printStackTrace(); // możesz logować
                }
            }
        }

        WeatherComparisonDTO dto = new WeatherComparisonDTO();
        dto.setCity1(city1);
        dto.setCity2(city2);
        dto.setComparison(comparison);
        return dto;
    }
}
