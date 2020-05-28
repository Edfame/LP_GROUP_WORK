package src.funcoes;

import src.Instrucao;
import src.TISC;

public class Locals extends Instrucao {

    private int argumentos;
    private int variaveis;

    public Locals(int argumentos, int variaveis) {

        this.argumentos = argumentos;
        this.variaveis = variaveis;
    }

    public int getVariaveis() {
        return variaveis;
    }

    public int getArgumentos() {
        return argumentos;
    }

    @Override
    public void executar(TISC tisc) {

        tisc.locals(argumentos, variaveis);
    }

    @Override
    public String toString() {
        return "Locals{" +
                "argumentos=" + argumentos +
                ", variaveis=" + variaveis +
                '}';
    }
}