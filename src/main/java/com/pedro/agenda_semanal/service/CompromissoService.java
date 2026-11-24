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

        private void validarHorario(Compromisso c) {
            if (!c.getFim().isAfter(c.getInicio())) {
                throw new IllegalArgumentException("O fim precisa ser depois do início");
            }
        }

        public List<Compromisso> listar() {
            List<Compromisso> compromissos = repository.findAll(); // Consulta ao banco

            compromissos.sort(Comparator.comparing(Compromisso::getDia).thenComparing(Compromisso::getInicio)); // ordena os dados

            return compromissos; // retorna os dados ordenados pelo sort()
        }

        public Optional<Compromisso> buscar(Long id) {
            return repository.findById(id);
        }


        public Compromisso criar(Compromisso novo, Compromisso dados) {

            validarHorario(dados);

            return repository.save(novo);
        }

        public boolean deletar(Long id) {

            if (!repository.existsById(id)) {
                return false;
            }
            repository.deleteById(id);
            return true;
        }

        public Optional<Compromisso> atualizar(Long id, Compromisso dados) {
            validarHorario(dados);                 // 1. regra primeiro (pode lançar exceção)

            if (!repository.existsById(id)) {         // 2. existe?
            return Optional.empty();              //    não: caixa vazia
            }

            dados.setId(id);                          // 3. o id da URL vai para o objeto
            return Optional.of(repository.save(dados));   // 4. save com id = UPDATE; caixa cheia
        }

}

