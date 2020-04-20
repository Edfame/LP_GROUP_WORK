package src.funcoes;

import src.Instrucao;

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
    public void executar() {

    }

    @Override
    public String toString() {
        return "Locals{" +
                "argumentos=" + argumentos +
                ", variaveis=" + variaveis +
                '}';
    }
}