package com.pedro.agenda_semanal.controller;


import com.pedro.agenda_semanal.model.Categoria;
import com.pedro.agenda_semanal.model.Compromisso;
import com.pedro.agenda_semanal.model.Dia;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
public class CompromissosController {
    private List<Compromisso> compromissos = new ArrayList<>();


    private final com.pedro.agenda_semanal.repository.CompromissoRepository repository;

    public CompromissosController(com.pedro.agenda_semanal.repository.CompromissoRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/compromissos")
    public List<Compromisso> listar(){

        compromissos.sort(Comparator.comparing(Compromisso::getDia).thenComparing(Compromisso::getInicio));
        return repository.findAll();
    }

    private Long proximoId = 6L;

    @PostMapping("/compromissos")
    @ResponseStatus(HttpStatus.CREATED)
    public Compromisso criar(@RequestBody Compromisso novo) {
        novo.setId(proximoId);
        proximoId++;
        compromissos.add(novo);
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
