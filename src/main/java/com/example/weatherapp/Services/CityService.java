package com.example.weatherapp.Services;

import com.example.weatherapp.Entity.City.City;
import com.example.weatherapp.Entity.City.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public Optional<Integer> getCityIdByName(String name) {
        return cityRepository.findByName(name).map(City::getId);
    }
}
