package com.kllm.practicaut8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kllm.practicaut8.model.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {
}