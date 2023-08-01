package com.disrupting.veterinaria.repositories;

import com.disrupting.veterinaria.entities.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}
