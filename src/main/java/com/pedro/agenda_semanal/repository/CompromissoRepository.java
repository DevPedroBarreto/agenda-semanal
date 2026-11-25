package com.pedro.agenda_semanal.repository;

import com.pedro.agenda_semanal.model.Compromisso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompromissoRepository extends JpaRepository<Compromisso, Long> {
}