package Fazenda;

public class Bovino extends Animal {
    private double producao_diaria;

    public Bovino(String nome, String raca, int idade) {
        super(nome, raca, idade);
    }
    public double getProducao_diaria() {
        return producao_diaria;
    }
    public void setProducao_diaria(int valor,int idBusca) {
        if(this.id==idBusca) {
            this.producao_diaria += valor;
        }}

}
