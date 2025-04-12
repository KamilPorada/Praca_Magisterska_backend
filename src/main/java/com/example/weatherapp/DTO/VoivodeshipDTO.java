package com.example.weatherapp.DTO;

public class VoivodeshipDTO {
    private Integer id;
    private String name;
    private String capital;
    private Double area;
    private Integer population;
    private Double density;
    private Integer countyCount;
    private Integer communeCount;

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getDensity() {
        return density;
    }

    public void setDensity(Double density) {
        this.density = density;
    }

    public Integer getCountyCount() {
        return countyCount;
    }

    public void setCountyCount(Integer countyCount) {
        this.countyCount = countyCount;
    }

    public Integer getCommuneCount() {
        return communeCount;
    }

    public void setCommuneCount(Integer communeCount) {
        this.communeCount = communeCount;
    }
}
