package main;


import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

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

        do {
            System.out.println("1 - Adicionar compromisso");
            System.out.println("2 - Listar semana");
            System.out.println("3 - Remover compromisso");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção do menu: ");

            String opcao = scanner.nextLine();
            int convertOpcao = Integer.parseInt(opcao);
            Dia dia = Dia.DOMINGO;
            Categoria categoria = Categoria.ESTUDOS;

            switch (convertOpcao){
                case 1:
                    System.out.println("Adicionando compromisso...");
                    System.out.print("Digite o nome do compromisso: ");
                    String userCompromisso = scanner.nextLine();
                    System.out.print("Digite o horario de inicio do compromisso: ");
                    String horarioUserInicio = scanner.nextLine();
                    LocalTime inicio = LocalTime.parse(horarioUserInicio);
                    System.out.print("Digite o horario Final do compromisso: ");
                    String horarioUserFim = scanner.nextLine();
                    LocalTime fim = LocalTime.parse(horarioUserFim);
                    if (!fim.isAfter(inicio)){
                        System.out.println("");
                        System.out.println("Voce cadastrou os horarios de forma errada! BURRÃO ");
                        System.out.println("");
                        break;
                    }
                    System.out.println("Qual dia da semana?");
                    System.out.println("1 - Segunda");
                    System.out.println("2 - Terça");
                    System.out.println("3 - Quarta");
                    System.out.println("4 - Quinta");
                    System.out.println("5 - Sexta");
                    System.out.println("6 - Sabado");
                    System.out.println("7 - Domingo");


                    String opcaoDia = scanner.nextLine();
                    int convertOpcaodia = Integer.parseInt(opcaoDia);
                    if (convertOpcaodia > 7){
                        System.out.println("Voce digitou uma opção invalida!");
                        break;
                    }else {
                        switch (convertOpcaodia){
                            case 1:
                                System.out.println("Segunda");
                                dia = Dia.SEGUNDA;
                                break;
                            case 2:
                                System.out.println("Terça");
                                dia = Dia.TERCA;
                                break;
                            case 3:
                                System.out.println("Quarta");
                                dia = Dia.QUARTA;
                                break;
                            case 4:
                                System.out.println("Quinta");
                                dia = Dia.QUINTA;
                                break;
                            case 5:
                                System.out.println("Sexta");
                                dia = Dia.SEXTA;

                                break;
                            case 6:
                                System.out.println("Sabado");
                                dia = Dia.SABADO;
                                break;
                            case 7:
                                System.out.println("Domingo");
                                dia = Dia.DOMINGO;
                                break;
                            default:
                                System.out.println("Opção invalida");
                                break;
                        }
                    }

                    System.out.println("Qual dia da Categoria?");
                    System.out.println("1 - Estudos");
                    System.out.println("2 - Profissional");
                    System.out.println("3 - Espiritual");
                    System.out.println("4 - Atividade Fisica");


                    String opcaoCategoria = scanner.nextLine();
                    int convertOpcaoCategoria = Integer.parseInt(opcaoCategoria);
                    if (convertOpcaoCategoria > 4){
                        System.out.println("Voce digitou uma opção invalida!");
                        break;
                    }else {
                        switch (convertOpcaoCategoria){
                            case 1:
                                System.out.println("Estudos");
                                categoria = Categoria.ESTUDOS;
                                break;
                            case 2:
                                System.out.println("Profissional");
                                categoria = Categoria.PROFISSIONAL;
                                break;
                            case 3:
                                System.out.println("Espiritual");
                                categoria = Categoria.ESPIRITUAL;
                                break;
                            case 4:
                                System.out.println("Atividade Fisica");
                                categoria = Categoria.ATIVIDADE_FISICA;
                                break;
                            default:
                                System.out.println("Opção invalida");
                                break;
                        }
                    }


                    compromisso.add(new Compromisso(userCompromisso, dia, inicio, fim, categoria ));

                    break;
                case 2:
                    System.out.println("LISTA COM OS COMPROMISSOS");
                    compromisso.sort(Comparator.comparing(Compromisso::getDia).thenComparing(Compromisso::getInicio));
                    for (int i = 0; i < compromisso.size(); i++) {
                        System.out.println("Numero " + (i + 1) + " " + compromisso.get(i).formatar());
                    }
                    break;
                case 3:

                    System.out.println("Digite o numero do compromisso que deseja remover");
                    for (int i = 0; i < compromisso.size(); i++) {
                        System.out.println("Numero " + i + " " + compromisso.get(i).formatar());
                    }
                    System.out.print("Numero: ");
                    String removUser = scanner.nextLine();
                    int convertRemovUser = Integer.parseInt(removUser);
                    compromisso.remove(convertRemovUser - 1);
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





        System.out.println("O total de compromissos: " + compromisso.size());


    }
}
