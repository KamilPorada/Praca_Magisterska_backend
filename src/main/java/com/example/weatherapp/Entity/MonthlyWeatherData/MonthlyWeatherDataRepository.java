package com.example.weatherapp.Entity.MonthlyWeatherData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonthlyWeatherDataRepository extends JpaRepository<MonthlyWeatherData, Integer> {
    List<MonthlyWeatherData> findByCityIdAndYearBetween(
            Integer cityId, Integer startYear, Integer endYear
    );
}
