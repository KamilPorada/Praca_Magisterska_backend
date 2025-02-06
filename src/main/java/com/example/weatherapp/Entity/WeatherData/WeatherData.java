package com.example.weatherapp.Entity.WeatherData;

import com.example.weatherapp.Entity.City.City;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @Column(nullable = false)
    private LocalDate date;

    private Double maxTemperature;
    private Double minTemperature;
    private Double maxFeelTemperature;
    private Double minFeelTemperature;
    private Double totalPrecipitation;
    private Double rain;
    private Double rainSnow;
    private Double snow;
    private Double precipitationDuration;
    private Integer weatherCode;
    private LocalDateTime sunrise;
    private LocalDateTime sunset;
    private Double sunlightDuration;
    private Double daylightDuration;
    private Double maxWindSpeed;
    private Double windGusts;
    private Integer dominantWindDirection;
    private Double totalSolarRadiation;
    private Double evapotranspiration;

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public Double getMaxFeelTemperature() {
        return maxFeelTemperature;
    }

    public void setMaxFeelTemperature(Double maxFeelTemperature) {
        this.maxFeelTemperature = maxFeelTemperature;
    }

    public Double getMinFeelTemperature() {
        return minFeelTemperature;
    }

    public void setMinFeelTemperature(Double minFeelTemperature) {
        this.minFeelTemperature = minFeelTemperature;
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

    public Double getRainSnow() {
        return rainSnow;
    }

    public void setRainSnow(Double rainSnow) {
        this.rainSnow = rainSnow;
    }

    public Double getSnow() {
        return snow;
    }

    public void setSnow(Double snow) {
        this.snow = snow;
    }

    public Double getPrecipitationDuration() {
        return precipitationDuration;
    }

    public void setPrecipitationDuration(Double precipitationDuration) {
        this.precipitationDuration = precipitationDuration;
    }

    public Integer getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(Integer weatherCode) {
        this.weatherCode = weatherCode;
    }

    public LocalDateTime getSunrise() {
        return sunrise;
    }

    public void setSunrise(LocalDateTime sunrise) {
        this.sunrise = sunrise;
    }

    public LocalDateTime getSunset() {
        return sunset;
    }

    public void setSunset(LocalDateTime sunset) {
        this.sunset = sunset;
    }

    public Double getSunlightDuration() {
        return sunlightDuration;
    }

    public void setSunlightDuration(Double sunlightDuration) {
        this.sunlightDuration = sunlightDuration;
    }

    public Double getDaylightDuration() {
        return daylightDuration;
    }

    public void setDaylightDuration(Double daylightDuration) {
        this.daylightDuration = daylightDuration;
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

    public Integer getDominantWindDirection() {
        return dominantWindDirection;
    }

    public void setDominantWindDirection(Integer dominantWindDirection) {
        this.dominantWindDirection = dominantWindDirection;
    }

    public Double getTotalSolarRadiation() {
        return totalSolarRadiation;
    }

    public void setTotalSolarRadiation(Double totalSolarRadiation) {
        this.totalSolarRadiation = totalSolarRadiation;
    }

    public Double getEvapotranspiration() {
        return evapotranspiration;
    }

    public void setEvapotranspiration(Double evapotranspiration) {
        this.evapotranspiration = evapotranspiration;
    }
}
