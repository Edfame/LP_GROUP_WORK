package src.aritmeticas;

import src.Instrucao;
import src.TISC;

public class Add extends Instrucao {

    public Add() {

    }

    @Override
    public void executar(TISC tisc) {

        tisc.add();

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
