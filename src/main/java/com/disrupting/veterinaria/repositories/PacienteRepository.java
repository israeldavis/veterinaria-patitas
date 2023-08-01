package com.disrupting.veterinaria.repositories;

import com.disrupting.veterinaria.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}
