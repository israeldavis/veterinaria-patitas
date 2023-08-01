package com.disrupting.veterinaria.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "veterinarios")
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El apellido paterno del veterinario es obligatorio")
    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @NotEmpty(message = "El apellido materno del veterinario es obligatorio")
    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @NotEmpty(message = "El nombre del veterinario es obligatorio")
    @Column(length = 50)
    private String nombre;

    @NotEmpty(message = "La cedula del veterinario es obligatoria")
    @Column(name = "cedula_profesional")
    private String cedulaProfesional;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedulaProfesional() {
        return cedulaProfesional;
    }

    public void setCedulaProfesional(String cedulaProfesional) {
        this.cedulaProfesional = cedulaProfesional;
    }
}
