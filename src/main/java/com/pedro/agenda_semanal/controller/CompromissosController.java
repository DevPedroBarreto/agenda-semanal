package com.pedro.agenda_semanal.controller;


import com.pedro.agenda_semanal.model.Compromisso;
import com.pedro.agenda_semanal.service.CompromissoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CompromissosController {

    private final CompromissoService service;      // não conhece mais o repository!

    public CompromissosController(CompromissoService service) {
        this.service = service;
    }


    @GetMapping("/compromissos")
    public List<Compromisso> listar(){
        return service.listar();
    }

    @PostMapping("/compromissos")
    public ResponseEntity<Compromisso> criar(@RequestBody Compromisso novo) {
        try {
            Compromisso criado = service.criar(novo);
            return ResponseEntity.status(HttpStatus.CREATED).body(criado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();          
        }
    }

    @GetMapping("/compromissos/{id}")
    public ResponseEntity<Compromisso> buscar(@PathVariable Long id){

        Optional<Compromisso> c = service.buscar(id);
        if (c.isPresent()) {
            return ResponseEntity.ok(c.get());
        }
        return ResponseEntity.notFound().build();
    }

}
