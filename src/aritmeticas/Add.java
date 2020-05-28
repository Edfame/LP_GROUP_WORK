package src.aritmeticas;

import src.Instrucao;
import src.TISC;

public class Add extends Instrucao {

    public Add() {

    }

    @Override
    public void executar(TISC tisc) {

        int direita = tisc.getPilhaDeAvaliacao().pop();
        int esquerda = tisc.getPilhaDeAvaliacao().pop();

        tisc.getPilhaDeAvaliacao().push(direita + esquerda);

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
