package com.example.weatherapp.Entity.TodayWeather;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class TodayWeather {

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("longitude")
    private double longitude;

    @JsonProperty("current")
    private CurrentWeather currentWeather;

    @JsonProperty("daily")
    private DailyWeather dailyWeather;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public DailyWeather getDailyWeather() {
        return dailyWeather;
    }

    public void setDailyWeather(DailyWeather dailyWeather) {
        this.dailyWeather = dailyWeather;
    }

    public static class CurrentWeather {

        @JsonProperty("temperature_2m")
        private double temperature;

        @JsonProperty("relative_humidity_2m")
        private int humidity;

        @JsonProperty("is_day")
        private boolean isDay;

        @JsonProperty("weather_code")
        private int weatherCode;

        @JsonProperty("surface_pressure")
        private double pressure;

        @JsonProperty("wind_speed_10m")
        private double windSpeed;

        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public boolean isDay() {
            return isDay;
        }

        public void setDay(boolean day) {
            isDay = day;
        }

        public int getWeatherCode() {
            return weatherCode;
        }

        public void setWeatherCode(int weatherCode) {
            this.weatherCode = weatherCode;
        }

        public double getPressure() {
            return pressure;
        }

        public void setPressure(double pressure) {
            this.pressure = pressure;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }
    }

    public static class DailyWeather {

        @JsonProperty("sunrise")
        private List<String> sunrise;

        @JsonProperty("sunset")
        private List<String> sunset;

        public List<String> getSunrise() {
            return sunrise;
        }

        public void setSunrise(List<String> sunrise) {
            this.sunrise = sunrise;
        }

        public List<String> getSunset() {
            return sunset;
        }

        public void setSunset(List<String> sunset) {
            this.sunset = sunset;
        }
    }
}
