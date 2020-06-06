package src.funcoes;

import src.Instrucao;
import src.TISC;

public class Return extends Instrucao {

    public Return() {

    }

    @Override
    public void executar(TISC tisc) {

        tisc.returnInst();

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
