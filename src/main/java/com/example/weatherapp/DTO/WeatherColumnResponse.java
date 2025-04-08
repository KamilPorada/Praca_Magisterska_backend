package com.example.weatherapp.DTO;

import java.util.List;

public class WeatherColumnResponse {
    private List<String> columns;

    public WeatherColumnResponse(List<String> columns) {
        this.columns = columns;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }
}
