package src.saida;

import src.Controlo;
import src.Instrucao;

public class Print extends Instrucao {

    public Print() {

    }

    @Override
    public void executar(Controlo controlo) {

        System.out.print(controlo.getPilhaDeAvaliacao().pop());

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
