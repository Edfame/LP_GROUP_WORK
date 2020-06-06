package src.aritmeticas;

import src.Instrucao;
import src.TISC;

public class Mult extends Instrucao {

    public Mult() {

    }

    @Override
    public void executar(TISC tisc) {

        tisc.mult();

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}