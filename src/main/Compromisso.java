package main;

public class Compromisso {
    private String titulo;
    private String dia;
    private String inicio;
    private String fim;
    private String categoria;

    public Compromisso(String titulo, String dia, String inicio, String fim, String categoria) {
        this.titulo = titulo;
        this.dia = dia;
        this.inicio = inicio;
        this.fim = fim;
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getDia() {
        return dia;
    }
    public String getInicio() {
        return inicio;
    }
    public String getFim() {
        return fim;
    }
    public String getCategoria() {
        return categoria;
    }

}
