package Fazenda;

import Uteis.Titulos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Fazenda.Tanque;

public class Fazenda {
    private String nome;
    private String endereco;

    private List<Animal> listaAnimal = new ArrayList<>();
    private List<Tanque> listaTanque = new ArrayList<>();
    private List<Bovino> listaAnimalBovino = new ArrayList<>();

    public Fazenda(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
    }
    public List<Animal> getListaAnimal() {
        return listaAnimal;
    }
    public List<Tanque> getListaTanque() {
        return listaTanque;
    }
    public List<Bovino> getListaAnimalBovino() {
        return listaAnimalBovino;
    }
    public void adicionaAnimal(Animal animal) {
        this.listaAnimal.add(animal);
    }
    public void adicionarTanque(Tanque tanque) {
        this.listaTanque.add(tanque);
    }
    public void adicionaAnimalBovino(Animal animal) {
        this.listaAnimalBovino.add((Bovino) animal);
    }

    // METODOS QUE GEREM OS ANIMAIS:

    // FUNÇÃO QUE IMPRIME TODOS OS ANIMAIS.
    public void imprimirAnimais() {
        if(listaAnimal.size()==0) {
            System.out.println("NÃO HÁ REGISTROS DE ANIMAIS!");}
        else {
            System.out.println("LISTA DE ANIMAIS: ");
            for(Animal animal:listaAnimal) {
                System.out.print("ID:" + animal.getId() + " | Nome: " + animal.getNome() + " | RAÇA: " + animal.getRaca() + " | Idade: " + animal.getIdade() +"|");
                if(animal instanceof Bovino) {
                    Bovino bovino=(Bovino) animal;
                    System.out.print(" Produção diária: " + bovino.getProducao_diaria());
                }
                System.out.println();}}
       }

    // FUNÇÃO QUE IMPRIME TODOS OS ANIMAIS BOVINOS.
    public void imprimirAnimaisBovinos() {
        if(listaAnimal.size()==0) {
            System.out.println("NÃO HÁ REGISTROS DE ANIMAIS BOVINOS!");}
        else {
            System.out.println("LISTA DE ANIMAIS: ");
            for(Bovino animal:listaAnimalBovino) {
                if(animal.getProducao_diaria()!=0) {
                        System.out.println("ID:" + animal.getId() + " | Nome: " + animal.getNome() + " | RAÇA: " + animal.getRaca() + " | Idade: " + animal.getIdade() +  " | Produção diária: " + animal.getProducao_diaria() + " LITROS |");}
                else{
                        System.out.println("ID: " + animal.getId() +" | NOME DO ANIMAL: " + animal.getNome() + " | PRODUÇÃO DO DIA: *SEM REGISTROS*");}}
        System.out.println();}}

    // FUNÇÃO QUE IMPRIME TODOS OS ANIMAIS DOENTES.
    public void imprimirAnimaisCOMdoenca() {
        if(listaAnimal.size()!=0) {
            System.out.println();
            System.out.println("LISTA DE ANIMAIS REPORTADOS COMO DOENTE: ");
            boolean temDoente = false;
            for(Animal animal:listaAnimal) {
                if(animal.getSaude() == false) {
                    System.out.println("ID:" + animal.getId() + " | Nome: " + animal.getNome() + " | RAÇA: " + animal.getRaca() + " | Idade: " + animal.getIdade()+ "|");
                    temDoente = true;}}
            if(!temDoente) {
                System.out.println("NÃO HÁ REGISTRO DE ANIMAIS DOENTES!");}}
        else {
            System.out.println("NÃO HÁ REGISTRO DE ANIMAIS!");}
      }
    // FUNÇÃO QUE REPORTA O ANIMAL COMO DOENTE.
    public void reportarDoenca(Scanner sc){
        boolean encontrado = false;
        if (listaAnimal.size() != 0) {
            imprimirAnimais();
            System.out.println();
            System.out.print("Digite o ID do animal:  ");
            int idAnimal = sc.nextInt();
            sc.nextLine();
            for (Animal animal : listaAnimal) {
                if (animal.getId() == idAnimal) {
                    animal.setSaude(false);
                    System.out.println("Animal reportado como doente com sucesso!");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Nenhum animal encontrado com o ID informado.");
            }
        } else {
            System.out.println("Não há registros de animais no sistema.");
        }
    }

    // FUNÇÃO QUE REPORTA MELHORAS DOS ANIMAIS.
    public  void reportarMelhoras(Scanner sc) {
        boolean encontrado = false;
        if(listaAnimal.size()!=0){
            imprimirAnimaisCOMdoenca();
            System.out.println();
            System.out.print("Digite o ID do animal:  ");
            int idAnimal=sc.nextInt();
            sc.nextLine();
            for(Animal animal:listaAnimal) {
                if(animal.getId() == idAnimal){
                    animal.setSaude(true);
                    encontrado = true;
                    System.out.println("Reportado com sucesso!");
                    break;}}
             if (!encontrado) {
                 System.out.println("Nenhum animal encontrado com o Id informado.");}
    } else{
            System.out.println("Não há registros de animais no sistema.");}
    }

    //  FUNÇÃO QUE GERA O RELATORIO DE PRODUÇAO
    public void gerarRelatorioProducao() {
        int soma=0;
        if (listaAnimal.isEmpty()){
            System.out.println("Nenhum animal encontrado!");
        } else {
            System.out.println("PRODUÇÃO POR ANIMAL:");

            for (Bovino animal : listaAnimalBovino) {
                soma+=animal.getProducao_diaria();
                System.out.print("Id do Animal: " + animal.getId() + "  | Nome do Animal: " + animal.getNome() + " | Raça do Animal: " + animal.getRaca() + " | Idade do Animal: " + animal.getIdade()  + " | Produção Total Diária: " + animal.getProducao_diaria());
                if (animal.getSaude() == true) {
                    System.out.println(" | Status do Animal: Saúdavel");
                } else{
                    System.out.println(" | Status do Animal: Não Saúdavel");}}}
        System.out.println();
        if(soma!=0){
            System.out.println("PRODUÇÃO DE LEITE TOTAL DO DIA: "+soma + " LITROS DE LEITE.");
        }
        else{
            System.out.println("SEM REGISTROS DE PRODUÇÃO DE LEITE!");
        }
        System.out.println();

    }
    // Atualizar Produção
    public void atualizarProducao(Scanner sc) {
        if(listaAnimal.size()!=0 && listaAnimalBovino.size()!=0) {
            imprimirAnimaisBovinos();
            System.out.print("ESCOLHA O ANIMAL PELO ID PARA REGISTRAR SUA PRODUÇÃO:");
            int busca=sc.nextInt();
            System.out.print("DIGITE O VALOR DA PRODUÇÃO: ");
            int valor=sc.nextInt();
            sc.nextLine();
            boolean encontrado = false;
            for(Animal animal: listaAnimal) {
                if(animal instanceof Bovino) {
                    Bovino bovino=(Bovino) animal;
                    if(animal.getId()==busca) {
                        bovino.setProducao_diaria(valor,busca);
                        System.out.println("PRODUÇÃO ATUALIZADA COM SUCESSO!");
                        encontrado=true;
                        break;}}}
            if (!encontrado) {
                System.out.println("NENHUM ANIMAL FOI ENCONTRADO COM O ID INFORMADO!");}}
        else{
            System.out.println("NENHUM REGISTRO DE UM ANIMAL BOVINO!");}

    }


    // METODOS QUE GEREM OS TANQUES:

    // FUNÇÃO QUE IMPRIME OS TANQUES;
    public void imprimirTanques() {
        if (listaTanque.size() != 0) {
            for (Tanque t : listaTanque) {
                System.out.println("ID: " + t.getId() + " | Capacidade: " + t.getCapacidadeMaxima() + "L | Volume armazenado: " + t.getQuantidadeAtual() + " |");
            }
        } else {
            System.out.println("NÃO HÁ REGISTROS DE TANQUES!");
        }
    }

    // FUNÇÃO  QUE ADICIONA LEITE NO TANQUE.
    public void addLeite( int id,int quantidade,String validade) {
        boolean encontrado=false;
        for(Tanque t:listaTanque) {
            if(id==t.getId()) {
                t.armazenarLeite(quantidade,validade);
                encontrado=true;
                break;}}
        if(!encontrado) {
            System.out.println("NENHUM TANQUE ENCONTRADO COM A ID INFORMADA!");}}

    // FUNÇÃO QUE REMOVE LEITE DO TANQUE;
    public void removerLeite(int quantidade, int id) {
        boolean encontrado=false;
        for(Tanque tanque: listaTanque) {
            if(id==tanque.getId()) {
                tanque.removerLeite(quantidade);
                encontrado=true;
                break;}}
        if(!encontrado) {
            System.out.println("NENHUM TANQUE ENCONTRADO COM A ID INFORMADA!");}}

    //  FUNÇAO QUE GERA O RELATORIO DE ARMAZENAMENTO
    public void gerarRelatorioArmazenamento() {
        System.out.println("RELATORIO DE ARMAZENAMENTO: ");

        if (listaTanque.isEmpty()){
            System.out.println("Nenhum tanque encontrado!");
        }
        else{
            for (Tanque tanque : listaTanque) {
                System.out.println("Id do Tanque: " + tanque.getId()
                        + " | Capacidade Máxima: "+ tanque.getCapacidadeMaxima()+ "Litros"
                        + " | Quantidade Atual:  "+ tanque.getQuantidadeAtual() + " Litros"
                        + " | Validade do Leite: "+ tanque.getValidadeDoleite()  );}}

    }



    // FUNÇAÕ QUE GERA O RELATORIO GERAL DE LEITE
    public void imprimirRelatorioGeral() {
        int somaArmazenamento=0;
        System.out.println("RELATORIO LEITE: ");
        if(listaTanque.size()!=0) {
            for(Tanque t: listaTanque) {
                double capacidadeLivre = t.getCapacidadeMaxima() - t.getQuantidadeAtual();
                somaArmazenamento+= t.getQuantidadeAtual();
                System.out.println("TANQUE: " + t.getId() + " | CAPACIDADE: " +  t.getCapacidadeMaxima() + " LITROS | CAPACIDADE EM USO: " + t.getQuantidadeAtual() + " LITROS | CAPACIDADE LIVRE: " + capacidadeLivre + " LITROS | VALIDADE DO LEITE: " + t.getValidadeDoleite());}
            System.out.println();
            System.out.println("QUANTIDADE DE LEITE ARMAZENADA: " + somaArmazenamento + " LITROS DE LEITE.");
       }
        else {
            System.out.println("NÃO HÁ REGISTROS DE LEITE EM TANQUES;");}}

}
