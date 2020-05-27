package src.aritmeticas;

import src.Controlo;
import src.Instrucao;

public class Mult extends Instrucao {

    public Mult() {

    }

    @Override
    public void executar(Controlo controlo) {

        int direita = controlo.getPilhaDeAvaliacao().pop();
        int esquerda = controlo.getPilhaDeAvaliacao().pop();

        controlo.getPilhaDeAvaliacao().push(direita * esquerda);

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}