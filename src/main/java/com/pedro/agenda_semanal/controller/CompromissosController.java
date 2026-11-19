package com.pedro.agenda_semanal.controller;


import com.pedro.agenda_semanal.model.Compromisso;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
public class CompromissosController {

    private final com.pedro.agenda_semanal.repository.CompromissoRepository repository;

    public CompromissosController(com.pedro.agenda_semanal.repository.CompromissoRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/compromissos")
    public List<Compromisso> listar(){
        List<Compromisso> compromissos = repository.findAll(); // Consulta ao banco

        compromissos.sort(Comparator.comparing(Compromisso::getDia).thenComparing(Compromisso::getInicio)); // ordena os dados

        return compromissos; // retorna os dados ordenados pelo sort()
    }

    @PostMapping("/compromissos")
    @ResponseStatus(HttpStatus.CREATED)
    public Compromisso criar(@RequestBody Compromisso novo) {
        return repository.save(novo);
    }

    @GetMapping("/compromissos/{id}")
    public ResponseEntity<Compromisso> buscar(@PathVariable Long id){


        Optional<Compromisso> c = repository.findById(id);

        if (c.isPresent()) {
            return ResponseEntity.ok(c.get());
        }
        return ResponseEntity.notFound().build();

    }
}
