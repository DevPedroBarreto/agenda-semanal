package main;


import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Compromisso compromisso1 = new Compromisso("Trabalho", Dia.SEGUNDA, LocalTime.parse("07:00"), LocalTime.parse("17:00"), Categoria.PROFISSIONAL );
        Compromisso compromisso2 = new Compromisso("Trabalho", Dia.TERCA, LocalTime.parse("07:00"), LocalTime.parse("17:00"), Categoria.PROFISSIONAL );
        Compromisso compromisso3 = new Compromisso("Trabalho", Dia.QUARTA, LocalTime.parse("07:00"), LocalTime.parse("17:00"), Categoria.PROFISSIONAL );
        Compromisso compromisso4 = new Compromisso("Trabalho", Dia.QUINTA, LocalTime.parse("07:00"), LocalTime.parse("17:00"), Categoria.PROFISSIONAL );
        Compromisso compromisso5 = new Compromisso("Trabalho", Dia.SEXTA, LocalTime.parse("07:00"), LocalTime.parse("17:00"), Categoria.PROFISSIONAL );
        Compromisso compromisso6 = new Compromisso("Campo", Dia.SABADO, LocalTime.parse("09:15"), LocalTime.parse("11:00"), Categoria.ESPIRITUAL );
        Compromisso compromisso7 = new Compromisso("Campo", Dia.DOMINGO, LocalTime.parse("09:15"), LocalTime.parse("11:00"), Categoria.ESPIRITUAL );

        Compromisso compromisso8 = new Compromisso("Faculdade", Dia.SEGUNDA, LocalTime.parse("17:45"), LocalTime.parse("18:50"), Categoria.ESTUDOS );

        Compromisso compromisso9 = new Compromisso("Bicicleta", Dia.TERCA, LocalTime.parse("17:45"), LocalTime.parse("18:50"), Categoria.ATIVIDADE_FISICA);

        System.out.println(compromisso1.getDia() + " | " + compromisso1.getInicio() + " - " + compromisso1.getFim() + " | " + compromisso1.getTitulo() + " | " + compromisso1.getCategoria());
        System.out.println(compromisso2.getDia() + " | " + compromisso2.getInicio() + " - " + compromisso2.getFim() + " | " + compromisso2.getTitulo() + " | " + compromisso2.getCategoria());
        System.out.println(compromisso3.getDia() + " | " + compromisso3.getInicio() + " - " + compromisso3.getFim() + " | " + compromisso3.getTitulo() + " | " + compromisso3.getCategoria());
        System.out.println(compromisso4.getDia() + " | " + compromisso4.getInicio() + " - " + compromisso4.getFim() + " | " + compromisso4.getTitulo() + " | " + compromisso4.getCategoria());
        System.out.println(compromisso5.getDia() + " | " + compromisso5.getInicio() + " - " + compromisso5.getFim() + " | " + compromisso5.getTitulo() + " | " + compromisso5.getCategoria());
        System.out.println(compromisso6.getDia() + " | " + compromisso6.getInicio() + " - " + compromisso6.getFim() + " | " + compromisso6.getTitulo() + " | " + compromisso6.getCategoria());
        System.out.println(compromisso7.getDia() + " | " + compromisso7.getInicio() + " - " + compromisso7.getFim() + " | " + compromisso7.getTitulo() + " | " + compromisso7.getCategoria());
        System.out.println(compromisso8.getDia() + " | " + compromisso8.getInicio() + " - " + compromisso8.getFim() + " | " + compromisso8.getTitulo() + " | " + compromisso8.getCategoria());
        System.out.println(compromisso9.getDia() + " | " + compromisso9.getInicio() + " - " + compromisso9.getFim() + " | " + compromisso9.getTitulo() + " | " + compromisso9.getCategoria());
    }
}
