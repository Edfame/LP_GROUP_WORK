package src.saida;

import src.Instrucao;
import src.TISC;

public class PrintNl extends Instrucao {

    public PrintNl() {

    }

    @Override
    public void executar(TISC tisc) {

        System.out.println();

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
