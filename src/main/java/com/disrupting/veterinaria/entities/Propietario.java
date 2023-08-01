package com.disrupting.veterinaria.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "propietarios")
public class Propietario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El apellido paterno del propietario es obligatorio")
    @Column(name = "apellido_paterno", length = 50)
    private String apellidoPaterno;

    @NotEmpty(message = "El apellido materno del propietario es obligatorio")
    @Column(name = "apellido_materno", length = 50)
    private String apellidoMaterno;

    @NotEmpty(message = "El nombre del propietario es obligatorio")
    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "telefono", length = 10)
    private String telefono;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "propietario_id")
    private List<Paciente> pacientes = new ArrayList<>();

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Propietario agregarCita(Long pacienteId, Cita cita) {
        Paciente paciente = getPaciente(pacienteId);
        paciente.addCita(cita);
        return this;
    }

    private Paciente getPaciente(Long pacienteId) {
        for(Paciente paciente : pacientes) {
            if(paciente.getId() == pacienteId) {
                return paciente;
            }
        }
        return null;
    }


}
