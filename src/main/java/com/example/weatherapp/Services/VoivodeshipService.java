package com.example.weatherapp.Services;

import com.example.weatherapp.DTO.VoivodeshipDTO;
import com.example.weatherapp.Entity.Voivodeship.Voivodeship;
import com.example.weatherapp.Entity.Voivodeship.VoivodeshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VoivodeshipService {

    @Autowired
    private VoivodeshipRepository voivodeshipRepository;

    public List<VoivodeshipDTO> getAllVoivodeships() {
        List<Voivodeship> voivodeships = voivodeshipRepository.findAll();
        return voivodeships.stream()
                .map(voivodeship -> {
                    VoivodeshipDTO dto = new VoivodeshipDTO();
                    dto.setId(voivodeship.getId());
                    dto.setName(voivodeship.getName());
                    dto.setCapital(voivodeship.getCapital());
                    dto.setArea(voivodeship.getArea());
                    dto.setPopulation(voivodeship.getPopulation());
                    dto.setDensity(voivodeship.getDensity());
                    dto.setCountyCount(voivodeship.getCountyCount());
                    dto.setCommuneCount(voivodeship.getCommuneCount());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
