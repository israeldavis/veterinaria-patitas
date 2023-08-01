package com.disrupting.veterinaria.controllers;

import com.disrupting.veterinaria.entities.Veterinario;
import com.disrupting.veterinaria.services.VeterinarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/veterinarios")
public class VeterinarioController {

    @Autowired
    private VeterinarioService veterinarioService;

    @GetMapping("/{id}")
    public Veterinario obtenerVeterinarioPorId(@PathVariable Long id) {
        return veterinarioService.obtenerVeterinarioPorId(id);
    }

    @GetMapping
    public List<Veterinario> obtenerListaVeterinarios() {
        return veterinarioService.obtenerListaVeterinarios();
    }

    @PostMapping
    public Veterinario crearVeterinario(@Valid @RequestBody Veterinario veterinario) {
        return veterinarioService.crearVeterinario(veterinario);
    }

}
