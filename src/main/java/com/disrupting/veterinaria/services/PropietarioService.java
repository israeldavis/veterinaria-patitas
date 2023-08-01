package com.disrupting.veterinaria.services;

import com.disrupting.veterinaria.entities.Propietario;

import java.util.List;

public interface PropietarioService {

    Propietario crearPropietario(Propietario propietario);

    Propietario obtenerPropietarioPorId(Long id);

    List<Propietario> obtenerListaPropietarios();
}
