package src.aritmeticas;

import src.Instrucao;
import src.TISC;

public class Sub extends Instrucao {

    public Sub() {

    }

    @Override
    public void executar(TISC tisc) {

        tisc.sub();

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
