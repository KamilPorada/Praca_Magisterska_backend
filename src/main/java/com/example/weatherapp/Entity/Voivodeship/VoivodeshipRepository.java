package com.example.weatherapp.Entity.Voivodeship;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VoivodeshipRepository extends JpaRepository<Voivodeship, Integer> {

    Optional<Voivodeship> findByName(String name);
}
