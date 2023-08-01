package com.disrupting.veterinaria.services.impl;

import com.disrupting.veterinaria.entities.Veterinario;
import com.disrupting.veterinaria.repositories.VeterinarioRepository;
import com.disrupting.veterinaria.services.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {

    @Autowired
    private VeterinarioRepository repository;

    @Override
    public Veterinario crearVeterinario(Veterinario veterinario) {
        return repository.save(veterinario);
    }

    @Override
    public Veterinario obtenerVeterinarioPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Veterinario con Id " + id + " no encontrado" ));
    }

    @Override
    public List<Veterinario> obtenerListaVeterinarios() {
        return repository.findAll();
    }
}
