package src.aritmeticas;

import src.Instrucao;
import src.TISC;

public class Div extends Instrucao {

    public Div() {

    }

    @Override
    public void executar(TISC tisc) {

        int direita = tisc.getPilhaDeAvaliacao().pop();
        int esquerda = tisc.getPilhaDeAvaliacao().pop();

        tisc.getPilhaDeAvaliacao().push(esquerda / direita);

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}