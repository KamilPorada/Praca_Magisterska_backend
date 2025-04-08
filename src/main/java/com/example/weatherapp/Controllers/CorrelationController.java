package com.example.weatherapp.Controllers;

import com.example.weatherapp.DTO.CorrelationResult;
import com.example.weatherapp.Services.CorrelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/correlation")
public class CorrelationController {

    @Autowired
    private CorrelationService correlationService;

    @GetMapping
    public ResponseEntity<CorrelationResult> getCorrelation(
            @RequestParam Integer cityId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam String column1,
            @RequestParam String column2) {

        CorrelationResult result = correlationService.calculateCorrelation(cityId, startDate, endDate, column1, column2);
        return ResponseEntity.ok(result);
    }
}
