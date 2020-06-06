package src.aritmeticas;

import src.Instrucao;
import src.TISC;

public class Mod extends Instrucao {

    public Mod() {

    }

    @Override
    public void executar(TISC tisc) {

        tisc.mod();

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}