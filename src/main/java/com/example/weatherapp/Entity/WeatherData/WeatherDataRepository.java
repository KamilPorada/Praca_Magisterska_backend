package com.example.weatherapp.Entity.WeatherData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface WeatherDataRepository extends JpaRepository<WeatherData, Integer> {

    List<WeatherData> findByCityId(Integer cityId);

    List<WeatherData> findByCityIdAndDate(Integer cityId, LocalDate date);

    List<WeatherData> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<WeatherData> findByCityIdAndDateBetween(Integer cityId, LocalDate startDate, LocalDate endDate);

}
