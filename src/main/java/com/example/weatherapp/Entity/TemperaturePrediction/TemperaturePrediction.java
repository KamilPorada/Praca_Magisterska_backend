package com.example.weatherapp.Entity.TemperaturePrediction;

import com.example.weatherapp.Entity.City.City;
import jakarta.persistence.*;

@Entity
@Table(name = "temperature_prediction")
public class TemperaturePrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(nullable = false)
    private Integer year;

    private Double predictionMaxTemperature;
    private Double predictionMinTemperature;

    @Transient
    private Double predictionAverageTemperature;

    @Transient
    private Double predictionAmplitude;

    @Transient
    private Integer estimatedGrowingSeasonDays;

    public Double getPredictionAverageTemperature() {
        if (predictionMaxTemperature != null && predictionMinTemperature != null) {
            return (predictionMaxTemperature + predictionMinTemperature) / 2;
        }
        return null;
    }

    public Double getPredictionAmplitude() {
        if (predictionMaxTemperature != null && predictionMinTemperature != null) {
            return predictionMaxTemperature - predictionMinTemperature;
        }
        return null;
    }

    public Integer getEstimatedGrowingSeasonDays() {
        Double avgTemp = getPredictionAverageTemperature();
        if (avgTemp == null) return null;

        if (avgTemp <= 0) return 0;
        if (avgTemp >= 10) return 250;

        // Interpolacja liniowa między 0°C (0 dni) a 10°C (250 dni)
        return (int) Math.round((avgTemp / 10) * 250);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getPredictionMaxTemperature() {
        return predictionMaxTemperature;
    }

    public void setPredictionMaxTemperature(Double predictionMaxTemperature) {
        this.predictionMaxTemperature = predictionMaxTemperature;
    }

    public Double getPredictionMinTemperature() {
        return predictionMinTemperature;
    }

    public void setPredictionMinTemperature(Double predictionMinTemperature) {
        this.predictionMinTemperature = predictionMinTemperature;
    }
}
