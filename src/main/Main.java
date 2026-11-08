package main;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Compromisso> compromisso = new ArrayList<>();

        compromisso.add(new Compromisso("Faculdade", Dia.SEGUNDA, LocalTime.parse("17:45"), LocalTime.parse("18:50"), Categoria.ESTUDOS));
        compromisso.add(new Compromisso("Trabalho", Dia.SEGUNDA, LocalTime.parse("07:00"), LocalTime.parse("17:00"), Categoria.PROFISSIONAL ));

        compromisso.add(new Compromisso("Trabalho", Dia.TERCA, LocalTime.parse("07:00"), LocalTime.parse("17:00"), Categoria.PROFISSIONAL ));

        compromisso.add(new Compromisso("Trabalho", Dia.QUARTA, LocalTime.parse("07:00"), LocalTime.parse("17:00"), Categoria.PROFISSIONAL));
        compromisso.add(new Compromisso("Trabalho", Dia.QUINTA, LocalTime.parse("07:00"), LocalTime.parse("17:00"), Categoria.PROFISSIONAL));
        compromisso.add(new Compromisso("Trabalho", Dia.SEXTA, LocalTime.parse("07:00"), LocalTime.parse("17:00"), Categoria.PROFISSIONAL));
        compromisso.add(new Compromisso("Campo", Dia.SABADO, LocalTime.parse("09:15"), LocalTime.parse("11:00"), Categoria.ESPIRITUAL));
        compromisso.add(new Compromisso("Campo", Dia.DOMINGO, LocalTime.parse("09:15"), LocalTime.parse("11:00"), Categoria.ESPIRITUAL));

        compromisso.add(new Compromisso("Bicicleta", Dia.TERCA, LocalTime.parse("17:45"), LocalTime.parse("18:50"), Categoria.ATIVIDADE_FISICA));

        compromisso.sort(Comparator.comparing(Compromisso::getDia).thenComparing(Compromisso::getInicio));

        for (int i = 0; i < compromisso.size(); i++) {
            System.out.println(compromisso.get(i).formatar());
        }

        System.out.println("O total de compromissos: " + compromisso.size());


    }
}
