package com.disrupting.veterinaria.services.impl;

import com.disrupting.veterinaria.entities.Cita;
import com.disrupting.veterinaria.entities.Paciente;
import com.disrupting.veterinaria.entities.Propietario;
import com.disrupting.veterinaria.repositories.CitaRepository;
import com.disrupting.veterinaria.repositories.PacienteRepository;
import com.disrupting.veterinaria.repositories.PropietarioRepository;
import com.disrupting.veterinaria.services.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
public class CitaServiceImpl implements CitaService {

    @Autowired
    private PropietarioRepository propietarioRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private CitaRepository citaRepository;


    @Override
    public Cita crearCita(Long propietarioId, Long pacienteId, Cita cita) {
        Propietario propietario = propietarioRepository.findById(propietarioId).orElseThrow(() -> new EntityNotFoundException("Propietario con id " + propietarioId + " no encontrado"));
        Paciente paciente = null;
        for(Paciente pac : propietario.getPacientes()) {
            if(pac.getId() == pacienteId) {
                paciente = pac;
            } else {
                throw new EntityNotFoundException("Paciente con id " + pacienteId + " no encontrado");
            }
        }

        paciente.getCitas().add(cita);

        return cita;
    }
}
