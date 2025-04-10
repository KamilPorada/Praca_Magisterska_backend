package com.example.weatherapp.Services;

import com.example.weatherapp.DTO.PolandWeatherDataDTO;
import com.example.weatherapp.Entity.WeatherData.WeatherData;
import com.example.weatherapp.Entity.WeatherData.WeatherDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolandWeatherDataService {

    private final WeatherDataRepository weatherDataRepository;

    @Autowired
    public PolandWeatherDataService(WeatherDataRepository weatherDataRepository) {
        this.weatherDataRepository = weatherDataRepository;
    }

    public List<PolandWeatherDataDTO> getWeatherDataForDate(LocalDate date) {
        List<WeatherData> weatherDataList = weatherDataRepository.findByDateBetween(date, date);
        return weatherDataList.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private PolandWeatherDataDTO mapToDTO(WeatherData data) {
        PolandWeatherDataDTO dto = new PolandWeatherDataDTO();
        dto.setCityId(data.getCity().getId());
        dto.setCityName(data.getCity().getName());
        dto.setDate(data.getDate());
        dto.setMaxTemperature(data.getMaxTemperature());
        dto.setMinTemperature(data.getMinTemperature());
        dto.setMaxFeelTemperature(data.getMaxFeelTemperature());
        dto.setMinFeelTemperature(data.getMinFeelTemperature());
        dto.setTotalPrecipitation(data.getTotalPrecipitation());
        dto.setRain(data.getRain());
        dto.setRainSnow(data.getRainSnow());
        dto.setSnow(data.getSnow());
        dto.setPrecipitationDuration(data.getPrecipitationDuration());
        dto.setWeatherCode(data.getWeatherCode());
        dto.setSunrise(data.getSunrise());
        dto.setSunset(data.getSunset());
        dto.setSunlightDuration(data.getSunlightDuration());
        dto.setDaylightDuration(data.getDaylightDuration());
        dto.setMaxWindSpeed(data.getMaxWindSpeed());
        dto.setWindGusts(data.getWindGusts());
        dto.setDominantWindDirection(data.getDominantWindDirection());
        dto.setTotalSolarRadiation(data.getTotalSolarRadiation());
        dto.setEvapotranspiration(data.getEvapotranspiration());
        return dto;
    }
}
