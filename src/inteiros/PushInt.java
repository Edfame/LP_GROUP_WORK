package src.inteiros;

import src.Instrucao;
import src.TISC;

public class PushInt extends Instrucao {

    private int inteiro;

    public PushInt(int inteiro) {

        this.inteiro = inteiro;

    }

    public int getInteiro() {
        return inteiro;
    }

    @Override
    public void executar(TISC tisc) {

        tisc.pushInt(inteiro);

    }

    @Override
    public String toString() {
        return "PushInt{" +
                "inteiro=" + inteiro +
                '}';
    }
}