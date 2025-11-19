package Fazenda;
public class Animal {
    private static int contador = 1;
    protected int id;
    protected String nome;
    protected String raca;
    protected int idade;
    protected boolean saude=true;

    public Animal(String nome, String raca, int idade){
        this.id = contador++;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public String getRaca(){
        return raca;
    }
    public int getIdade(){
        return idade;
    }
    public boolean getSaude() {
        return saude;
    }
    public void setSaude(boolean saude) {
        this.saude = saude;
    }
}
