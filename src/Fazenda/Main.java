package Fazenda;

import Uteis.*;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        Fazenda fazenda = new Fazenda("Pitombeira","Santa Cruz");
        Titulos.welcome();
        Titulos.tFazenda();
        while(true){
            Menus.menuPrincipal();
            System.out.print("ESCOLHA A OPÇÃO DESEJADA: ");
            String opc=sc.nextLine();
            switch(opc){
                case "1":
                    boolean repeticao = false;
                    while(repeticao == false){
                    Titulos.tCadastrar();
                    System.out.print("DIGITE O NOME DO ANIMAL:");
                    String nomeanimal=sc.nextLine();
                    System.out.print("DIGITE A RAÇA DO ANIMAL:");
                    String racaanimal=sc.nextLine();
                    System.out.print("DIGITE QUAL A IDADE DO ANIMAL");
                    int idadeanimal =sc.nextInt();
                    sc.nextLine();
                    boolean validade = false;
                    while(validade == false){
                        System.out.print("O ANIMAL PRODUZ LEITE? - DIGITE (S) PARA SIM E (N) PARA NÃO.");
                        String animalleite = sc.nextLine().toUpperCase();
                        switch(animalleite){
                            case "S":
                                Animal vaca = new Bovino(nomeanimal, racaanimal, idadeanimal);
                                fazenda.adicionaAnimalBovino(vaca);
                                fazenda.adicionaAnimal(vaca);
                                validade = true;
                                break;
                            case "N":
                                Animal boi = new Animal(nomeanimal, racaanimal, idadeanimal);
                                fazenda.adicionaAnimal(boi);
                                validade = true;
                                break;
                            default:
                                System.out.println("OPÇÃO INVÁLIDA, DIGITE NOVAMENTE.");
                                break;}}
                    boolean escolha1 = false;
                    while(escolha1 == false){
                    System.out.print("DESEJA ADICIONAR OUTRO ANIMAL? - DIGITE (S) PARA SIM E (N) PARA NÃO.");
                    String escolha=sc.nextLine().toUpperCase();
                    switch(escolha){
                        case "S":
                            escolha1 = true;
                            break;
                        case "N":
                            escolha1 = true;
                            repeticao = true;
                            break;
                        default:
                            System.out.println("OPÇÃO INVÁLIDA, DIGITE NOVAMENTE.");
                             break;}}}
                    break;
                case "2":
                    boolean sairDoMenuTanque = false;
                    while (!sairDoMenuTanque) {
                        Menus.menuTanque();
                        System.out.print("ESCOLHA A OPÇÃO DESEJADA: ");
                        String opc2 = sc.nextLine();

                        switch (opc2) {
                            case "1":
                                Titulos.tcTanque();
                                System.out.println("O ID DO TANQUE É GERADO AUTOMATICAMENTE PELO SISTEMA! ");
                                System.out.print("CAPACIDADE DO TANQUE: ");
                                int capacidade = sc.nextInt();
                                sc.nextLine();
                                Tanque tanque = new Tanque(capacidade);
                                fazenda.adicionarTanque(tanque);;
                                System.out.println("TANQUE CRIADO COM SUCESSO!");
                                break;
                            case "2":
                                Titulos.tcLeite();
                                fazenda.imprimirTanques();
                                System.out.println();
                                break;

                            case "3":
                                System.out.println();
                                Titulos.tcADDLeite();
                                System.out.print("DIGITE O ID DO TANQUE QUE DESEJA ADICIONAR ESSE LEITE: ");
                                int idTanque = sc.nextInt();
                                System.out.print("DIGITE A QUANTIDADE DE LEITE: ");
                                int quantidade = sc.nextInt();
                                sc.nextLine();
                                System.out.print("DIGITE A VALIDADE DO LEITE: (dd/MM/yyyy) :");
                                String validade = sc.nextLine();
                                fazenda.addLeite(idTanque, quantidade,validade);
                                System.out.println();
                                break;

                            case "4":
                                Titulos.tcRemoverLeite();
                                fazenda.imprimirTanques();
                                System.out.println();
                                System.out.print("DIGITE A QUANTIDADE DE LEITE QUE DESEJA REMOVER: ");
                                int quantidadeRemover=sc.nextInt();
                                System.out.print("DIGITE O ID DO TANQUE QUE DESEJA REMOVER O LEITE: ");
                                int id=sc.nextInt();
                                fazenda.removerLeite(quantidadeRemover,id);
                                break;
                            case "5":
                                sairDoMenuTanque = true;
                                break;
                            default: System.out.println("Opção inválida.");
                                break; }}
                    break;

                case "3":
                    Titulos.tControle();
                    fazenda.atualizarProducao(sc);
                    break;
                case "4":
                    Titulos.tRelatorio();
                    fazenda.gerarRelatorioProducao();
                    fazenda.gerarRelatorioArmazenamento();
                    break;
                case "5":
                    Titulos.tListaA();
                    fazenda.imprimirAnimais();
                    fazenda.imprimirAnimaisCOMdoenca();
                    break;
                case "6":
                    Titulos.tRGeral();
                    fazenda.imprimirRelatorioGeral();
                    break;

                case "7":
                    Titulos.tSaude();
                    fazenda.reportarDoenca(sc);
                    break;
                case "8":
                    Titulos.tSaude();
                    fazenda.reportarMelhoras(sc);
                    break;
                case "9":
                    System.out.println("PROGRAMA ENCERRADO!.");
                    return;
                default:
                    System.out.println("Opção invalida!");
                    break;


            }}
    }}





