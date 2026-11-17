package main;

import java.time.LocalTime;

public class Compromisso {
    private String titulo;
    private Dia dia;
    private LocalTime inicio;
    private LocalTime fim;
    private Categoria categoria;

    public Compromisso(String titulo, Dia dia, LocalTime inicio, LocalTime fim, Categoria categoria) {
        this.titulo = titulo;
        this.dia = dia;
        this.inicio = inicio;
        this.fim = fim;
        this.categoria = categoria;
    }

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

    public String formatar(){
        return "[" + dia + " | " + inicio + " - " + fim + " | " +  titulo + " | " + categoria + "]";
    }

}
