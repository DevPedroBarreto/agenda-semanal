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

    private final CompromissoService service;

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

    @DeleteMapping("/compromissos/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.deletar(id)) {
            return ResponseEntity.noContent().build();    // 204: apagou, nada para devolver
        }
        return ResponseEntity.notFound().build();         // 404: não existia
    }


    @GetMapping("/compromissos/{id}")
    public ResponseEntity<Compromisso> buscar(@PathVariable Long id){

        Optional<Compromisso> c = service.buscar(id);
        if (c.isPresent()) {
            return ResponseEntity.ok(c.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/compromissos/{id}")
    public ResponseEntity<Compromisso> atualizar(@PathVariable Long id, @RequestBody Compromisso dados) {
        try {
            Optional<Compromisso> atualizado = service.atualizar(id, dados);
            if (atualizado.isPresent()) {
                return ResponseEntity.ok(atualizado.get());       // 200
            }
            return ResponseEntity.notFound().build();             // 404
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();           // 400
        }
    }

}
