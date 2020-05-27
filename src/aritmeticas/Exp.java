package src.aritmeticas;

import src.Controlo;
import src.Instrucao;

import java.util.ArrayList;
import java.util.Stack;

public class Exp extends Instrucao {

    public Exp() {

    }

    @Override
    public void executar(Controlo controlo) {

        int direita = controlo.getPilhaDeAvaliacao().pop();
        int esquerda = controlo.getPilhaDeAvaliacao().pop();

        controlo.getPilhaDeAvaliacao().push((int) Math.pow(esquerda, direita));

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
