package com.disrupting.veterinaria.services;

import com.disrupting.veterinaria.entities.Veterinario;

import java.util.List;

public interface VeterinarioService {

    Veterinario crearVeterinario(Veterinario veterinario);

    Veterinario obtenerVeterinarioPorId(Long id);

    List<Veterinario> obtenerListaVeterinarios();
}
