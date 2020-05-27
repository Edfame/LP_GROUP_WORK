package src.saida;

import src.Controlo;
import src.Instrucao;

public class PrintNl extends Instrucao {

    public PrintNl() {

    }

    @Override
    public void executar(Controlo controlo) {

        System.out.println();

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
