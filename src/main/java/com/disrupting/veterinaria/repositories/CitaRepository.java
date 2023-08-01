package com.disrupting.veterinaria.repositories;

import com.disrupting.veterinaria.entities.Cita;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitaRepository extends JpaRepository<Cita, Long> {
}
