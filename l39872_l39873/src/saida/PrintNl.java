package src.saida;

import src.Instrucao;
import src.TISC;

public class PrintNl extends Instrucao {

    public PrintNl() {

    }

    @Override
    public void executar(TISC tisc) {

        tisc.printNl();

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
