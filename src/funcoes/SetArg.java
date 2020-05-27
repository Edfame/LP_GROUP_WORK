package src.funcoes;

import src.Controlo;
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
    public void executar(Controlo controlo) {

    }

    @Override
    public String toString() {
        return "SetArg{" +
                "numero=" + numero +
                '}';
    }
}