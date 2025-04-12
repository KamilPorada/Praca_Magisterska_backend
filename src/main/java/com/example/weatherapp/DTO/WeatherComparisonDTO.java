package com.example.weatherapp.DTO;

import com.example.weatherapp.Entity.City.City;
import java.util.Map;

public class WeatherComparisonDTO {
    private City city1;
    private City city2;
    private Map<String, ComparisonResult> comparison;

    public static class ComparisonResult {
        private String larger;
        private double difference;

        public ComparisonResult(String larger, double difference) {
            this.larger = larger;
            this.difference = difference;
        }

        public String getLarger() {
            return larger;
        }

        public void setLarger(String larger) {
            this.larger = larger;
        }

        public double getDifference() {
            return difference;
        }

        public void setDifference(double difference) {
            this.difference = difference;
        }
    }

    public City getCity1() {
        return city1;
    }

    public void setCity1(City city1) {
        this.city1 = city1;
    }

    public City getCity2() {
        return city2;
    }

    public void setCity2(City city2) {
        this.city2 = city2;
    }

    public Map<String, ComparisonResult> getComparison() {
        return comparison;
    }

    public void setComparison(Map<String, ComparisonResult> comparison) {
        this.comparison = comparison;
    }
}
