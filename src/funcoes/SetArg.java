package src.funcoes;

import src.Instrucao;
import src.TISC;

public class SetArg extends Instrucao {

    private int numero;

    public SetArg(int numero) {

        this.numero = numero;

    }

    public int getNumero() {
        return numero;
    }

    @Override
    public void executar(TISC tisc) {

        tisc.setArg(numero);

    }

    @Override
    public String toString() {
        return "SetArg{" +
                "numero=" + numero +
                '}';
    }
}