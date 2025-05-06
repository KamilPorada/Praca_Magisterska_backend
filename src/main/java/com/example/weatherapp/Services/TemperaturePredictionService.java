package com.example.weatherapp.Services;

import com.example.weatherapp.DTO.TemperaturePredictionDTO;
import com.example.weatherapp.Entity.YearlyWeatherData.YearlyWeatherData;
import com.example.weatherapp.Entity.TemperaturePrediction.TemperaturePrediction;
import com.example.weatherapp.Entity.YearlyWeatherData.YearlyWeatherDataRepository;
import com.example.weatherapp.Entity.TemperaturePrediction.TemperaturePredictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemperaturePredictionService {

    private final TemperaturePredictionRepository temperaturePredictionRepository;
    private final YearlyWeatherDataRepository yearlyWeatherDataRepository;

    public TemperaturePredictionService(TemperaturePredictionRepository temperaturePredictionRepository,
                                        YearlyWeatherDataRepository yearlyWeatherDataRepository) {
        this.temperaturePredictionRepository = temperaturePredictionRepository;
        this.yearlyWeatherDataRepository = yearlyWeatherDataRepository;
    }

    public List<TemperaturePredictionDTO> getTemperatureDataForCity(Integer cityId) {
        List<YearlyWeatherData> historicalData = yearlyWeatherDataRepository
                .findByYearGreaterThanEqualAndCity_Id(1950, cityId);

        List<TemperaturePrediction> predictions = temperaturePredictionRepository.findByCity_Id(cityId);

        List<TemperaturePredictionDTO> result = new ArrayList<>();

        for (YearlyWeatherData data : historicalData) {
            result.add(mapToDto(data.getYear(), data.getCity().getName(),
                    data.getMinTemperature(), data.getMaxTemperature()));
        }

        for (TemperaturePrediction prediction : predictions) {
            result.add(mapToDto(prediction.getYear(), prediction.getCity().getName(),
                    prediction.getPredictionMinTemperature(), prediction.getPredictionMaxTemperature()));
        }

        return result.stream()
                .sorted(Comparator.comparing(TemperaturePredictionDTO::getYear))
                .collect(Collectors.toList());
    }

    private TemperaturePredictionDTO mapToDto(int year, String cityName, Double minTemp, Double maxTemp) {
        double average = (minTemp + maxTemp) / 2.0;
        double amplitude = maxTemp - minTemp;

        // Wzór interpolowany na długość okresu wegetacyjnego (min 5°C)
        int estimatedGrowingSeasonDays = (int) Math.round((average - 5.0) * 30.0);
        estimatedGrowingSeasonDays = Math.max(0, Math.min(estimatedGrowingSeasonDays, 365)); // ograniczenie do 0-365

        TemperaturePredictionDTO dto = new TemperaturePredictionDTO();
        dto.setYear(year);
        dto.setCity(cityName);
        dto.setMinTemperature(minTemp);
        dto.setMaxTemperature(maxTemp);
        dto.setAverageTemperature(average);
        dto.setPredictionAmplitude(amplitude);
        dto.setEstimatedGrowingSeasonDays(estimatedGrowingSeasonDays);

        return dto;
    }
}