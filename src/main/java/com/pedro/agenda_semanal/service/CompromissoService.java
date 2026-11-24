package com.pedro.agenda_semanal.service;

import com.pedro.agenda_semanal.model.Compromisso;
import com.pedro.agenda_semanal.repository.CompromissoRepository;

import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Service                                       // "esta classe é um service; Spring, crie e gerencie"
public class CompromissoService {

        private final CompromissoRepository repository;

        public CompromissoService(CompromissoRepository repository) {   // injeção de dependência, como no controller
            this.repository = repository;
        }

        public List<Compromisso> listar() {
            List<Compromisso> compromissos = repository.findAll(); // Consulta ao banco

            compromissos.sort(Comparator.comparing(Compromisso::getDia).thenComparing(Compromisso::getInicio)); // ordena os dados

            return compromissos; // retorna os dados ordenados pelo sort()
        }

        public Optional<Compromisso> buscar(Long id) {
            return repository.findById(id);
        }

        public Compromisso criar(Compromisso novo) {
            if (!novo.getFim().isAfter(novo.getInicio())) {
                throw new IllegalArgumentException("O fim precisa ser depois do início");
            }
            return repository.save(novo);
        }
}

