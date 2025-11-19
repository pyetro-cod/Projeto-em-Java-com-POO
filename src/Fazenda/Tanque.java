package Fazenda;

public class Tanque {

    private static int contador =1;
    private  int id;
    private int CapacidadeMaxima;
    private int QuantidadeAtual;
    private String ValidadeDoleite;

    public Tanque(int capacidadeMaxima) {
        this.id = contador++;
        this.CapacidadeMaxima = capacidadeMaxima;
    }
    public int getId() {
        return id;
    }
    public int getCapacidadeMaxima() {
        return CapacidadeMaxima;
    }
    public int getQuantidadeAtual() {
        return QuantidadeAtual;
    }
    public String getValidadeDoleite() {
        return ValidadeDoleite;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        CapacidadeMaxima = capacidadeMaxima;
    }
    public void setQuantidadeAtual(int quantidadeAtual) {
        QuantidadeAtual = quantidadeAtual;
    }
    public void setValidadeDoleite(String validadeDoleite) {
        ValidadeDoleite = validadeDoleite;
    }

    public void  armazenarLeite(int quantidade, String Validade){
        if (QuantidadeAtual + quantidade <=CapacidadeMaxima){
            QuantidadeAtual += quantidade;
            System.out.println("Leita armazenado com êxito!");
            this.ValidadeDoleite=Validade;

        } else {
            System.out.println("Capacidade estourada!");
        }
    }
    public void removerLeite(int quantidade){
        if (quantidade <= QuantidadeAtual){
            QuantidadeAtual -= quantidade;
            System.out.println("Leite removido com êxito!");
        } else{
            System.out.println("Não tem leite para remover");
        }
    }
}
