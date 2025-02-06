package com.example.weatherapp.Entity.Voivodeship;

import jakarta.persistence.*;

@Entity
public class Voivodeship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String capital;

    @Column(nullable = true)
    private Double area;

    @Column(nullable = true)
    private Integer population;

    @Column(nullable = true)
    private Double density;

    @Column(nullable = false)
    private Integer countyCount;

    @Column(nullable = false)
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
