package src;

public class StoreArg extends Instrucao {

    private int distancia;
    private int numero;

    public StoreArg(int distancia, int numero) {

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