package src.aritmeticas;

import src.Instrucao;
import src.TISC;

public class Div extends Instrucao {

    public Div() {

    }

    @Override
    public void executar(TISC tisc) {

        tisc.div();

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}