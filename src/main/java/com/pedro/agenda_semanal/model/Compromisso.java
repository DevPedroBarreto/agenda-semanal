package com.pedro.agenda_semanal.model;

import jakarta.persistence.*;

import java.time.LocalTime;
@Entity
@Table(name = "compromissos")
public class Compromisso {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Enumerated(EnumType.STRING)
    private Dia dia;

    private LocalTime inicio;
    private LocalTime fim;

    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    public Compromisso(Long id, String titulo, Dia dia, LocalTime inicio, LocalTime fim, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.dia = dia;
        this.inicio = inicio;
        this.fim = fim;
        this.categoria = categoria;
    }
    public Compromisso(){};

    public Long getId() {return id;}
    public String getTitulo() {
        return titulo;
    }
    public Dia getDia() {
        return dia;
    }
    public LocalTime getInicio() {
        return inicio;
    }
    public LocalTime getFim() {
        return fim;
    }
    public Categoria getCategoria() {
        return categoria;
    }

    public void setId(Long id){
        this.id = id;
    }

}
