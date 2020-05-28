package src.aritmeticas;

import src.Instrucao;
import src.TISC;

public class Exp extends Instrucao {

    public Exp() {

    }

    @Override
    public void executar(TISC tisc) {

        int direita = tisc.getPilhaDeAvaliacao().pop();
        int esquerda = tisc.getPilhaDeAvaliacao().pop();

        tisc.getPilhaDeAvaliacao().push((int) Math.pow(esquerda, direita));

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
