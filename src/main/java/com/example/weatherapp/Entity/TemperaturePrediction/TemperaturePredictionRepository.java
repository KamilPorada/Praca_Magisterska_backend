package com.example.weatherapp.Entity.TemperaturePrediction;

import com.example.weatherapp.Entity.TemperaturePrediction.TemperaturePrediction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TemperaturePredictionRepository extends JpaRepository<TemperaturePrediction, Integer> {
    List<TemperaturePrediction> findByCity_Id(Integer cityId);
}
