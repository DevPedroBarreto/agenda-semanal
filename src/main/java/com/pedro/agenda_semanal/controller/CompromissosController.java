package com.pedro.agenda_semanal.controller;


import com.pedro.agenda_semanal.model.Categoria;
import com.pedro.agenda_semanal.model.Compromisso;
import com.pedro.agenda_semanal.model.Dia;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class CompromissosController {
    private List<Compromisso> compromissos = new ArrayList<>();



    public CompromissosController(){
        compromissos.add(new Compromisso(1L, "Trabalho", Dia.SEGUNDA, LocalTime.parse("07:00"), LocalTime.parse("17:00"), Categoria.PROFISSIONAL));
        compromissos.add(new Compromisso(2L, "Pedalar", Dia.SEGUNDA, LocalTime.parse("17:40"), LocalTime.parse("18:40"), Categoria.ATIVIDADE_FISICA));
        compromissos.add(new Compromisso(3L, "Aula da Faculdade", Dia.SEGUNDA, LocalTime.parse("18:50"), LocalTime.parse("20:00"), Categoria.ESTUDOS));
        compromissos.add(new Compromisso(4L, "Trabalho", Dia.TERCA, LocalTime.parse("07:00"), LocalTime.parse("17:00"), Categoria.PROFISSIONAL));
        compromissos.add(new Compromisso(5L, "Preparar parte e Reunião", Dia.TERCA, LocalTime.parse("17:40"), LocalTime.parse("20:00"), Categoria.ESPIRITUAL));
    }

    @GetMapping("/compromissos")
    public List<Compromisso> listar(){

        compromissos.sort(Comparator.comparing(Compromisso::getDia).thenComparing(Compromisso::getInicio));
        return compromissos;
    }

    private Long proximoId = 6L;

    @PostMapping("/compromissos")
    @ResponseStatus(HttpStatus.CREATED)                  // responde 201 em vez de 200
    public Compromisso criar(@RequestBody Compromisso novo) {  // "pegue o JSON do corpo e transforme num Lembrete"
        novo.setId(proximoId);                          // o SERVIDOR escolhe o id
        proximoId++;
        compromissos.add(novo);
        return novo;                                     // devolve o lembrete criado, já com id
    }

}
