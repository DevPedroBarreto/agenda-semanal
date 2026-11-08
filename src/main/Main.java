package main;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Compromisso> compromisso = new ArrayList<>();

        System.out.println("Seja bem vindo ao Sistema de Agenda");
        System.out.println("");
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;

        System.out.println("MENU");
        System.out.println("");
        System.out.println("1 - Adicionar compromisso");
        System.out.println("2 - Listar semana");
        System.out.println("3 - Remover compromisso");
        System.out.println("0 - Sair");

        do {
            System.out.println("Digite o nome do compromisso: ");
            int opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    System.out.println("Adicionando compromisso...");
                    System.out.println("");
                    System.out.println("Digite o nome do compromisso: ");
                    String userCompromisso = scanner.next();
                    System.out.println("Digite o horario de inicio do compromisso: ");
                    System.out.println("");
                    LocalTime inicio = LocalTime.parse(scanner.nextLine());
                    compromisso.add(new Compromisso(userCompromisso, inicio,))
                    break;
                case 2:
                    System.out.println("case 2");
                    break;
                case 3:
                    System.out.println("case 3");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção não existente!");
                    break;
            }

        }while (sair == false);

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
