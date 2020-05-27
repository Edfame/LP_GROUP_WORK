package src.inteiros;

import src.Controlo;
import src.Instrucao;

public class PushInt extends Instrucao {

    private int inteiro;

    public PushInt(int inteiro) {

        this.inteiro = inteiro;

    }

    public int getInteiro() {
        return inteiro;
    }

    @Override
    public void executar(Controlo controlo) {

        controlo.getPilhaDeAvaliacao().push(inteiro);

    }

    @Override
    public String toString() {
        return "PushInt{" +
                "inteiro=" + inteiro +
                '}';
    }
}