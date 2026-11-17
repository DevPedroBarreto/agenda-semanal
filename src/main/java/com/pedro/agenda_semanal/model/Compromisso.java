package com.pedro.agenda_semanal.model;

import java.time.LocalTime;

public class Compromisso {
    private Long id;
    private String titulo;
    private Dia dia;
    private LocalTime inicio;
    private LocalTime fim;
    private Categoria categoria;

    public Compromisso(Long id, String titulo, Dia dia, LocalTime inicio, LocalTime fim, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.dia = dia;
        this.inicio = inicio;
        this.fim = fim;
        this.categoria = categoria;
    }

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

    public Compromisso(){};


    public String formatar(){
        return "["+ id +" | " + dia + " | " + inicio + " - " + fim + " | " +  titulo + " | " + categoria + "]";
    }

}
