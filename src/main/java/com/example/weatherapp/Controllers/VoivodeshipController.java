package com.example.weatherapp.Controllers;

import com.example.weatherapp.DTO.VoivodeshipDTO;
import com.example.weatherapp.Services.VoivodeshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/voivodeships")
public class VoivodeshipController {

    @Autowired
    private VoivodeshipService voivodeshipService;

    @GetMapping
    public List<VoivodeshipDTO> getAllVoivodeships() {
        return voivodeshipService.getAllVoivodeships();
    }
}
