package src.aritmeticas;

import src.Instrucao;
import src.TISC;

public class Mult extends Instrucao {

    public Mult() {

    }

    @Override
    public void executar(TISC tisc) {

        int direita = tisc.getPilhaDeAvaliacao().pop();
        int esquerda = tisc.getPilhaDeAvaliacao().pop();

        tisc.getPilhaDeAvaliacao().push(direita * esquerda);

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}