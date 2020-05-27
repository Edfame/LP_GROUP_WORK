package src.aritmeticas;

import src.Controlo;
import src.Instrucao;

public class Sub extends Instrucao {

    public Sub() {

    }

    @Override
    public void executar(Controlo controlo) {

        int direita = controlo.getPilhaDeAvaliacao().pop();
        int esquerda = controlo.getPilhaDeAvaliacao().pop();

        controlo.getPilhaDeAvaliacao().push(esquerda - direita);

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
