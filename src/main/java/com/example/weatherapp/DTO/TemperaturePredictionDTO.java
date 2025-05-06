package com.example.weatherapp.DTO;

public class TemperaturePredictionDTO {
    private int year;
    private String city;
    private Double minTemperature;
    private Double maxTemperature;
    private Double averageTemperature;
    private Double predictionAmplitude;
    private Integer estimatedGrowingSeasonDays;

    // Gettery i Settery

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public Double getAverageTemperature() {
        return averageTemperature;
    }

    public void setAverageTemperature(Double averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public Double getPredictionAmplitude() {
        return predictionAmplitude;
    }

    public void setPredictionAmplitude(Double predictionAmplitude) {
        this.predictionAmplitude = predictionAmplitude;
    }

    public Integer getEstimatedGrowingSeasonDays() {
        return estimatedGrowingSeasonDays;
    }

    public void setEstimatedGrowingSeasonDays(Integer estimatedGrowingSeasonDays) {
        this.estimatedGrowingSeasonDays = estimatedGrowingSeasonDays;
    }
}
