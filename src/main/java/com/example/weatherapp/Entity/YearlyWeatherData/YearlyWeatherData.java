package com.example.weatherapp.Entity.YearlyWeatherData;

import com.example.weatherapp.Entity.City.City;
import jakarta.persistence.*;

@Entity
@Table(name = "weather_data_year")
public class YearlyWeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;
    @Column(nullable = false)
    private Integer year;

    private Double maxTemperature;
    private Double minTemperature;
    private Double maxFeelsLikeTemperature;
    private Double minFeelsLikeTemperature;
    private Double maxWindSpeed;
    private Double windGusts;
    private Double totalPrecipitation;
    private Double rain;
    private Double snow;
    private Double precipitationTime;
    private Integer weatherCode;
    private Double dominantWindDirection;

    // Getters and Setters
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

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getMaxFeelsLikeTemperature() {
        return maxFeelsLikeTemperature;
    }

    public void setMaxFeelsLikeTemperature(Double maxFeelsLikeTemperature) {
        this.maxFeelsLikeTemperature = maxFeelsLikeTemperature;
    }

    public Double getMinFeelsLikeTemperature() {
        return minFeelsLikeTemperature;
    }

    public void setMinFeelsLikeTemperature(Double minFeelsLikeTemperature) {
        this.minFeelsLikeTemperature = minFeelsLikeTemperature;
    }

    public Double getMaxWindSpeed() {
        return maxWindSpeed;
    }

    public void setMaxWindSpeed(Double maxWindSpeed) {
        this.maxWindSpeed = maxWindSpeed;
    }

    public Double getWindGusts() {
        return windGusts;
    }

    public void setWindGusts(Double windGusts) {
        this.windGusts = windGusts;
    }

    public Double getTotalPrecipitation() {
        return totalPrecipitation;
    }

    public void setTotalPrecipitation(Double totalPrecipitation) {
        this.totalPrecipitation = totalPrecipitation;
    }

    public Double getRain() {
        return rain;
    }

    public void setRain(Double rain) {
        this.rain = rain;
    }

    public Double getSnow() {
        return snow;
    }

    public void setSnow(Double snow) {
        this.snow = snow;
    }

    public Double getPrecipitationTime() {
        return precipitationTime;
    }

    public void setPrecipitationTime(Double precipitationTime) {
        this.precipitationTime = precipitationTime;
    }

    public Integer getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(Integer weatherCode) {
        this.weatherCode = weatherCode;
    }

    public Double getDominantWindDirection() {
        return dominantWindDirection;
    }

    public void setDominantWindDirection(Double dominantWindDirection) {
        this.dominantWindDirection = dominantWindDirection;
    }
}
