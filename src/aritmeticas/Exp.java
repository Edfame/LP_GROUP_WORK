package src.aritmeticas;

import src.Instrucao;
import src.TISC;

public class Exp extends Instrucao {

    public Exp() {

    }

    @Override
    public void executar(TISC tisc) {

        tisc.exp();

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
