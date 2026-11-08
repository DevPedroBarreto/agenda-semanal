package main;


public class Main {
    public static void main(String[] args) {
        Compromisso compromisso1 = new Compromisso("Trabalho", "Segunda", "7:00", "17:00", "Profissional" );
        Compromisso compromisso2 = new Compromisso("Trabalho", "Terça", "7:00", "17:00", "Profissional" );
        Compromisso compromisso3 = new Compromisso("Trabalho", "Quarta", "7:00", "17:00", "Profissional" );
        Compromisso compromisso4 = new Compromisso("Trabalho", "Quinta", "7:00", "17:00", "Profissional" );
        Compromisso compromisso5 = new Compromisso("Trabalho", "Sexta", "7:00", "17:00", "Profissional" );
        Compromisso compromisso6 = new Compromisso("Campo", "Sabado", "9:15", "11:00", "Espiritual" );
        Compromisso compromisso7 = new Compromisso("Campo", "Domingo", "9:15", "11:00", "Espiritual" );

        Compromisso compromisso8 = new Compromisso("Faculdade", "Segunda", "17:45", "18:50", "Estudos" );

        Compromisso compromisso9 = new Compromisso("Bicicleta", "Terça", "17:45", "18:50", "Exercícios" );

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
