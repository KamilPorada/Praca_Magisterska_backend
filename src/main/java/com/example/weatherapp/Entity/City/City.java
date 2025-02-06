package com.example.weatherapp.Entity.City;

import com.example.weatherapp.Entity.Voivodeship.Voivodeship;
import jakarta.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "voivodeship_id", nullable = false)
    private Voivodeship voivodeship;

    private Integer population;
    private Double area;
    private Double longitude;
    private Double latitude;
    private Double populationDensity;

    // Konstruktor bezparametrowy (wymagany przez JPA)
    public City() {}

    // Konstruktor z parametrami
    public City(String name, Voivodeship voivodeship, Integer population, Double area, Double longitude, Double latitude, Double populationDensity) {
        this.name = name;
        this.voivodeship = voivodeship;
        this.population = population;
        this.area = area;
        this.longitude = longitude;
        this.latitude = latitude;
        this.populationDensity = populationDensity;
    }

    // Gettery i Settery
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

    public Voivodeship getVoivodeship() {
        return voivodeship;
    }

    public void setVoivodeship(Voivodeship voivodeship) {
        this.voivodeship = voivodeship;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getPopulationDensity() {
        return populationDensity;
    }

    public void setPopulationDensity(Double populationDensity) {
        this.populationDensity = populationDensity;
    }
}
