package com.disrupting.veterinaria.controllers;

import com.disrupting.veterinaria.entities.Cita;
import com.disrupting.veterinaria.services.CitaService;
import com.disrupting.veterinaria.services.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/propietarios")
public class CitaController {

    @Autowired
    private PropietarioService propietarioService;

    @Autowired
    private CitaService citaService;

    @PostMapping("/{propietarioId}/pacientes/{pacienteId}/citas")
    public Cita crearCita(@Valid @RequestBody Cita cita, @PathVariable Long propietarioId, @PathVariable Long pacienteId) {
        return citaService.crearCita(propietarioId, pacienteId, cita);
    }
}
