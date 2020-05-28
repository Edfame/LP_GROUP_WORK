package src.saida;

import src.Instrucao;
import src.TISC;

public class Print extends Instrucao {

    public Print() {

    }

    @Override
    public void executar(TISC tisc) {

        System.out.print(tisc.getPilhaDeAvaliacao().pop());

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
