package com.kllm.practicaut8.model;

import jakarta.persistence.*;

@Entity
public class Participante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellidos;
    private int edad;
    private String alergiaAlimentaria;

    @ManyToOne
    @JoinColumn(name = "actividad_id")
    private Actividad actividad;

    public Participante() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getAlergiaAlimentaria() { return alergiaAlimentaria; }
    public void setAlergiaAlimentaria(String alergiaAlimentaria) { this.alergiaAlimentaria = alergiaAlimentaria; }
    public Actividad getActividad() { return actividad; }
    public void setActividad(Actividad actividad) { this.actividad = actividad; }
}