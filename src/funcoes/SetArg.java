package src.funcoes;

import src.Instrucao;

public class SetArg extends Instrucao {

    private int numero;

    public SetArg(int numero) {

        this.numero = numero;

    }

    public int getNumero() {
        return numero;
    }

    @Override
    public void executar() {

    }

    @Override
    public String toString() {
        return "SetArg{" +
                "numero=" + numero +
                '}';
    }
}