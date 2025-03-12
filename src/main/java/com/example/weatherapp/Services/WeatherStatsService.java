package com.example.weatherapp.Services;

import com.example.weatherapp.Entity.WeatherData.WeatherData;
import com.example.weatherapp.Entity.WeatherData.WeatherDataRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class WeatherStatsService {

    private final WeatherDataRepository weatherDataRepository;

    public WeatherStatsService(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    public Map<String, Object> getWeatherStats(Integer cityId, LocalDate startDate, LocalDate endDate) {
        List<WeatherData> data = weatherDataRepository.findByCityIdAndDateBetween(cityId, startDate, endDate);

        if (data.isEmpty()) {
            return Map.of("message", "Brak danych dla podanych parametrów");
        }

        Map<String, Object> stats = new HashMap<>();

        stats.put("maxTemperature", createStatBlock(data.stream().map(WeatherData::getMaxTemperature).collect(Collectors.toList())));
        stats.put("minTemperature", createStatBlock(data.stream().map(WeatherData::getMinTemperature).collect(Collectors.toList())));
        stats.put("feltMaxTemperature", createStatBlock(data.stream().map(WeatherData::getMaxFeelTemperature).collect(Collectors.toList())));
        stats.put("feltMinTemperature", createStatBlock(data.stream().map(WeatherData::getMinFeelTemperature).collect(Collectors.toList())));

        stats.put("totalPrecipitation", Map.of(
                "sum", round(sum(data.stream().map(WeatherData::getTotalPrecipitation).collect(Collectors.toList()))),
                "max", round(max(data.stream().map(WeatherData::getTotalPrecipitation).collect(Collectors.toList()))),
                "rainyDays", countNonZero(data.stream().map(WeatherData::getTotalPrecipitation).collect(Collectors.toList())),
                "dryDays", countZero(data.stream().map(WeatherData::getTotalPrecipitation).collect(Collectors.toList()))
        ));
        stats.put("rain", createSumMaxBlock(data.stream().map(WeatherData::getRain).collect(Collectors.toList())));
        stats.put("snow", createSumMaxBlock(data.stream().map(WeatherData::getSnow).collect(Collectors.toList())));

        stats.put("precipitationDuration", Map.of(
                "total", round(sum(data.stream().map(WeatherData::getPrecipitationDuration).collect(Collectors.toList()))),
                "longest", round(max(data.stream().map(WeatherData::getPrecipitationDuration).collect(Collectors.toList())))
        ));

        stats.put("weatherCode", Map.of("mode", mode(data.stream().map(WeatherData::getWeatherCode).collect(Collectors.toList()))));

        stats.put("sunrise", Map.of(
                "earliest", minString(data.stream().map(WeatherData::getSunrise).collect(Collectors.toList())),
                "latest", maxString(data.stream().map(WeatherData::getSunrise).collect(Collectors.toList()))
        ));
        stats.put("sunset", Map.of(
                "earliest", minString(data.stream().map(WeatherData::getSunset).collect(Collectors.toList())),
                "latest", maxString(data.stream().map(WeatherData::getSunset).collect(Collectors.toList()))
        ));

        stats.put("daylightDuration", createStatBlock(data.stream().map(d -> d.getDaylightDuration() / 3600.0).collect(Collectors.toList())));
        stats.put("sunlightDuration", createStatBlock(data.stream().map(d -> d.getSunlightDuration() / 3600.0).collect(Collectors.toList())));

        stats.put("maxWindSpeed", createStatBlock(data.stream().map(WeatherData::getMaxWindSpeed).collect(Collectors.toList())));
        stats.put("windGusts", createStatBlock(data.stream().map(WeatherData::getWindGusts).collect(Collectors.toList())));

        stats.put("dominantWindDirection", Map.of("mode", mode(data.stream().map(WeatherData::getDominantWindDirection).collect(Collectors.toList()))));

        stats.put("totalSolarRadiation", Map.of(
                "sum", round(sum(data.stream().map(WeatherData::getTotalSolarRadiation).collect(Collectors.toList()))),
                "averageDaily", round(average(data.stream().map(WeatherData::getTotalSolarRadiation).collect(Collectors.toList()))),
                "maxDaily", round(max(data.stream().map(WeatherData::getTotalSolarRadiation).collect(Collectors.toList()))),
                "minDaily", round(min(data.stream().map(WeatherData::getTotalSolarRadiation).collect(Collectors.toList())))
        ));
        stats.put("evapotranspiration", Map.of(
                "sum", round(sum(data.stream().map(WeatherData::getEvapotranspiration).collect(Collectors.toList()))),
                "averageDaily", round(average(data.stream().map(WeatherData::getEvapotranspiration).collect(Collectors.toList()))),
                "maxDaily", round(max(data.stream().map(WeatherData::getEvapotranspiration).collect(Collectors.toList()))),
                "minDaily", round(min(data.stream().map(WeatherData::getEvapotranspiration).collect(Collectors.toList())))
        ));

        return stats;
    }


    private Map<String, Double> createStatBlock(List<Double> values) {
        return Map.of(
                "average", round(average(values)),
                "min", round(min(values)),
                "max", round(max(values)),
                "median", round(median(values)),
                "stdDev", round(stdDev(values))
        );
    }

    private Map<String, Double> createSumMaxBlock(List<Double> values) {
        return Map.of(
                "sum", round(sum(values)),
                "max", round(max(values))
        );
    }

    private double average(List<Double> values) {
        return values.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    private double sum(List<Double> values) {
        return values.stream().mapToDouble(Double::doubleValue).sum();
    }

    private double min(List<Double> values) {
        return values.stream().mapToDouble(Double::doubleValue).min().orElse(0);
    }

    private double max(List<Double> values) {
        return values.stream().mapToDouble(Double::doubleValue).max().orElse(0);
    }

    private double median(List<Double> values) {
        List<Double> sorted = values.stream().sorted().collect(Collectors.toList());
        int size = sorted.size();
        if (size == 0) return 0;
        if (size % 2 == 0) return (sorted.get(size / 2 - 1) + sorted.get(size / 2)) / 2.0;
        return sorted.get(size / 2);
    }

    private double stdDev(List<Double> values) {
        double avg = average(values);
        return Math.sqrt(values.stream().mapToDouble(v -> Math.pow(v - avg, 2)).average().orElse(0));
    }

    private long countNonZero(List<Double> values) {
        return values.stream().filter(v -> v > 0).count();
    }

    private long countZero(List<Double> values) {
        return values.stream().filter(v -> v == 0).count();
    }

    private int mode(List<Integer> values) {
        return values.stream()
                .collect(Collectors.groupingBy(v -> v, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0);
    }

    private String minString(List<LocalDateTime> values) {
        return values.stream().min(LocalDateTime::compareTo)
                .map(LocalDateTime::toString)
                .orElse("00:00");
    }

    private String maxString(List<LocalDateTime> values) {
        return values.stream().max(LocalDateTime::compareTo)
                .map(LocalDateTime::toString)
                .orElse("00:00");
    }


    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
