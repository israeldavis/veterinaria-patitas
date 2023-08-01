package com.disrupting.veterinaria.services.impl;

import com.disrupting.veterinaria.entities.Paciente;
import com.disrupting.veterinaria.entities.Propietario;
import com.disrupting.veterinaria.repositories.PacienteRepository;
import com.disrupting.veterinaria.repositories.PropietarioRepository;
import com.disrupting.veterinaria.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PropietarioRepository propietarioRepository;


    @Override
    public Paciente obtenerPacientePorId(Long propietarioId, Long pacienteId) {
        Optional<Propietario> propietarioOptional = propietarioRepository.findById(propietarioId);
        if(!propietarioOptional.isPresent()) {
            throw new EntityNotFoundException("Propietario con id " + propietarioId + " no encontrado");
        }

        Propietario propietario = propietarioOptional.get();

        Paciente pacienteFound = null;
        for (Paciente paciente : propietario.getPacientes()) {
            if (paciente.getId() == pacienteId) {
                pacienteFound = paciente;
                break;
            }
        }
        return pacienteFound;
    }

    @Override
    public List<Paciente> obtenerPacientesPorPropietarioId(Long propietarioId) {
        Optional<Propietario> propietarioOptional = propietarioRepository.findById(propietarioId);
        if(!propietarioOptional.isPresent()) {
            throw new EntityNotFoundException("Propietario con id " + propietarioId + " no encontrado");
        }

        Propietario propietario = propietarioOptional.get();
        List<Paciente> pacientes = propietario.getPacientes();
        return pacientes;
    }

    @Override
    public void crearPaciente(Long propietarioId, Paciente paciente) {
        Optional<Propietario> propietarioOptional = propietarioRepository.findById(propietarioId);

        if(!propietarioOptional.isPresent()) {
            throw new EntityNotFoundException("Propietario con id " + propietarioId + " no encontrado");
        }

        Propietario propietarioFound = propietarioOptional.get();

        propietarioFound.getPacientes().add(paciente);

    }


}
