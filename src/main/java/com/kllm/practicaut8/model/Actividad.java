package com.kllm.practicaut8.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String monitor;
    private int edadMinima;
    private int plazas;
    private int duracion;


    @OneToMany(mappedBy = "actividad", cascade = CascadeType.ALL)
    private List<Participante> participantes;

    public Actividad() {}

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getMonitor() { return monitor; }
    public void setMonitor(String monitor) { this.monitor = monitor; }
    public int getEdadMinima() { return edadMinima; }
    public void setEdadMinima(int edadMinima) { this.edadMinima = edadMinima; }
    public int getPlazas() { return plazas; }
    public void setPlazas(int plazas) { this.plazas = plazas; }
    public int getDuracion() { return duracion; }
    public void setDuracion(int duracion) { this.duracion = duracion; }
}