package src.argumentos;

import src.Controlo;
import src.Instrucao;

import java.util.ArrayList;
import java.util.Stack;

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
    public void executar(Controlo controlo) {

    }

    @Override
    public String toString() {
        return "StoreArg{" +
                "distancia=" + distancia +
                ", numero=" + numero +
                '}';
    }
}