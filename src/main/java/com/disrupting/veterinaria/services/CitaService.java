package com.disrupting.veterinaria.services;

import com.disrupting.veterinaria.entities.Cita;

public interface CitaService {

    Cita crearCita(Long propietarioId, Long pacienteId, Cita cita);
}
