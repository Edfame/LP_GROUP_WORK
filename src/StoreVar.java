package src;

public class StoreVar extends Instrucao {

    private int distancia;
    private int numero;

    public StoreVar(int distancia, int numero) {

        this.distancia = distancia;
        this.numero = numero;

    }

    public int getDistancia() {
        return distancia;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public void executar() {

    }
}