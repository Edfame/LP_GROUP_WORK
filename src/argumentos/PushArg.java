package src.argumentos;

import src.Instrucao;

public class PushArg extends Instrucao {

    private int distancia;
    private int numero;

    public PushArg(int distancia, int numero) {

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

    @Override
    public String toString() {
        return "PushArg{" +
                "distancia=" + distancia +
                ", numero=" + numero +
                '}';
    }
}