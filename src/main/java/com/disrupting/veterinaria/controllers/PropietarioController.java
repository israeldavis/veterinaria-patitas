package com.disrupting.veterinaria.controllers;

import com.disrupting.veterinaria.entities.Propietario;
import com.disrupting.veterinaria.services.PropietarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/propietarios")
public class PropietarioController {

    @Autowired
    private PropietarioService propietarioService;

    @GetMapping("/{id}")
    public Propietario obtenerPropietarioPorId(@PathVariable Long id) {
        return propietarioService.obtenerPropietarioPorId(id);
    }

    @GetMapping
    public List<Propietario> obtenerListaPropietarios() {
        return propietarioService.obtenerListaPropietarios();
    }

    @PostMapping
    public Propietario crearPropietario(@Valid @RequestBody Propietario propietario) {
        return propietarioService.crearPropietario(propietario);
    }

}
