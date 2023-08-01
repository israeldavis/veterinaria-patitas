package com.disrupting.veterinaria.services.impl;

import com.disrupting.veterinaria.entities.Propietario;
import com.disrupting.veterinaria.repositories.PropietarioRepository;
import com.disrupting.veterinaria.services.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class PropietarioServiceImpl implements PropietarioService {

    @Autowired
    private PropietarioRepository repository;

    @Override
    public Propietario crearPropietario(Propietario propietario) {
        return repository.save(propietario);
    }

    @Override
    public Propietario obtenerPropietarioPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Propietario con Id " + id + " no encontrado" ));
    }

    @Override
    public List<Propietario> obtenerListaPropietarios() {
        return repository.findAll();
    }
}
