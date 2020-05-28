package src.saida;

import src.Instrucao;
import src.TISC;

public class Print extends Instrucao {

    public Print() {

    }

    @Override
    public void executar(TISC tisc) {

        tisc.print();

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
