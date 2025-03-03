package com.example.weatherapp.Controllers;

import com.example.weatherapp.Entity.City.City;
import com.example.weatherapp.Services.CityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin(origins = "*") // Jeśli potrzebujesz dostępu z frontendu
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getCityIdByName(@PathVariable String name) {
        Optional<Integer> cityId = cityService.getCityIdByName(name);
        return cityId.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
