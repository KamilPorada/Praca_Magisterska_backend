package com.example.weatherapp.Entity.YearlyWeatherData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YearlyWeatherDataRepository extends JpaRepository<YearlyWeatherData, Integer> {
    List<YearlyWeatherData> findByCityIdAndYearBetween(Integer cityId, Integer startYear, Integer endYear);
}
