package src;

public class PushVar extends Instrucao {

    private int distancia;
    private int numero;

    public PushVar(int distancia, int numero) {

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