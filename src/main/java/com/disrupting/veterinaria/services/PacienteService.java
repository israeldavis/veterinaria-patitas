package com.disrupting.veterinaria.services;

import com.disrupting.veterinaria.entities.Paciente;

import java.util.List;

public interface PacienteService {

    Paciente obtenerPacientePorId(Long propietarioId, Long pacienteId);

    List<Paciente> obtenerPacientesPorPropietarioId(Long id);

    void crearPaciente(Long propietarioId, Paciente paciente);

}
