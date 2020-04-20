package src.inteiros;

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
    public void executar() {

    }

    @Override
    public String toString() {
        return "PushInt{" +
                "inteiro=" + inteiro +
                '}';
    }
}