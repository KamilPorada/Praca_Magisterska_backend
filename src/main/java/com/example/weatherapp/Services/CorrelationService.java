package com.example.weatherapp.Services;

import com.example.weatherapp.DTO.CorrelationResult;
import com.example.weatherapp.Entity.WeatherData.WeatherData;
import com.example.weatherapp.Entity.WeatherData.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.*;

@Service
public class CorrelationService {

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    public CorrelationResult calculateCorrelation(Integer cityId, LocalDate startDate, LocalDate endDate, String column1, String column2) {

        List<WeatherData> dataList = weatherDataRepository.findByCityIdAndDateBetween(cityId, startDate, endDate);

        List<Double> values1 = new ArrayList<>();
        List<Double> values2 = new ArrayList<>();

        for (WeatherData data : dataList) {
            try {
                Field field1 = WeatherData.class.getDeclaredField(column1);
                Field field2 = WeatherData.class.getDeclaredField(column2);
                field1.setAccessible(true);
                field2.setAccessible(true);

                Object val1 = field1.get(data);
                Object val2 = field2.get(data);

                if (val1 instanceof Number && val2 instanceof Number) {
                    values1.add(((Number) val1).doubleValue());
                    values2.add(((Number) val2).doubleValue());
                }

            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException("Niepoprawna nazwa kolumny: " + e.getMessage());
            }
        }

        double correlation = computePearson(values1, values2);

        return new CorrelationResult(correlation, column1, column2, values1, values2);
    }

    private double computePearson(List<Double> x, List<Double> y) {
        if (x.size() != y.size() || x.size() == 0) return 0;

        int n = x.size();
        double sumX = x.stream().mapToDouble(Double::doubleValue).sum();
        double sumY = y.stream().mapToDouble(Double::doubleValue).sum();
        double sumXY = 0;
        double sumX2 = 0;
        double sumY2 = 0;

        for (int i = 0; i < n; i++) {
            double xi = x.get(i);
            double yi = y.get(i);
            sumXY += xi * yi;
            sumX2 += xi * xi;
            sumY2 += yi * yi;
        }

        double numerator = n * sumXY - sumX * sumY;
        double denominator = Math.sqrt((n * sumX2 - sumX * sumX) * (n * sumY2 - sumY * sumY));

        if (denominator == 0) return 0;
        return numerator / denominator;
    }
}
