package com.disrupting.veterinaria.controllers;

import com.disrupting.veterinaria.entities.Paciente;
import com.disrupting.veterinaria.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/propietarios")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/{propietarioId}/pacientes")
    public Paciente crearPaciente(@PathVariable Long propietarioId, @Valid @RequestBody Paciente paciente) {
        pacienteService.crearPaciente(propietarioId, paciente);
        return paciente;
    }
}
