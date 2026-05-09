package com.kllm.practicaut8;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.kllm.practicaut8.model.Actividad;
import com.kllm.practicaut8.model.Participante;
import com.kllm.practicaut8.repository.ActividadRepository;
import com.kllm.practicaut8.repository.ParticipanteRepository;

@SpringBootApplication
public class Practicaut8Application {

    public static void main(String[] args) {
        SpringApplication.run(Practicaut8Application.class, args);
    }

    @Bean
    public CommandLineRunner initData(ActividadRepository actRepo, ParticipanteRepository partRepo) {
        return args -> {
            // Creamos 10 actividades y 10 participantes vinculados
            for (int i = 1; i <= 10; i++) {
                // 1. Crear Actividad (Campamento)
                Actividad a = new Actividad();
                a.setNombre("Taller de " + (i % 2 == 0 ? "Naturaleza " : "Deporte ") + i);
                a.setMonitor("Monitor Especialista " + i);
                a.setEdadMinima(6 + (i % 3)); // Ejemplo: edades entre 6 y 8
                a.setPlazas(15 + i);
                actRepo.save(a);

                // 2. Crear Participante asignado a esa actividad
                Participante p = new Participante();
                p.setNombre("Alumno " + i);
                p.setApellidos("Apellido " + i);
                p.setEdad(7 + (i % 5)); // Ejemplo: edades entre 7 y 11
                p.setAlergiaAlimentaria(i % 4 == 0 ? "Frutos secos" : "Ninguna");
                p.setActividad(a); // Establecemos la relación
                partRepo.save(p);
            }
            System.out.println("--- DATOS INICIALES DEL CAMPAMENTO CARGADOS ---");
        };
    }
}