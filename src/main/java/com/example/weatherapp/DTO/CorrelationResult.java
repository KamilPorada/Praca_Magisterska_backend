package com.example.weatherapp.DTO;

import java.util.List;

public class CorrelationResult {
    private double correlation;
    private String column1;
    private String column2;
    private List<Double> values1;
    private List<Double> values2;

    public CorrelationResult(double correlation, String column1, String column2, List<Double> values1, List<Double> values2) {
        this.correlation = correlation;
        this.column1 = column1;
        this.column2 = column2;
        this.values1 = values1;
        this.values2 = values2;
    }

    public double getCorrelation() {
        return correlation;
    }

    public String getColumn1() {
        return column1;
    }

    public String getColumn2() {
        return column2;
    }

    public List<Double> getValues1() {
        return values1;
    }

    public List<Double> getValues2() {
        return values2;
    }
}
