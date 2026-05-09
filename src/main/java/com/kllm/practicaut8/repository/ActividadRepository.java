package com.kllm.practicaut8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kllm.practicaut8.model.Actividad;

@Repository
public interface ActividadRepository extends JpaRepository<Actividad, Long> {
    // JpaRepository ya te da todos los métodos: save, findAll, delete, etc.
}