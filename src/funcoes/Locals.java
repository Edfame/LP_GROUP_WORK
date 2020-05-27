package src.funcoes;

import src.Controlo;
import src.Instrucao;

import java.util.ArrayList;
import java.util.Stack;

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

    private void adicionarRA(Controlo controlo) {

        controlo.getMemoriaDeExecucao().add(controlo.getEvp());
        controlo.getMemoriaDeExecucao().add(null);
        controlo.getMemoriaDeExecucao().add(null);

        for (int i = 0; i < argumentos + variaveis; i++) {

            controlo.getMemoriaDeExecucao().add(null);
        }
    }

    @Override
    public void executar(Controlo controlo) {

        if (controlo.getEvp() == -1) {

            adicionarRA(controlo);
            controlo.setEvp(0);

        } else {

            int newEvp = controlo.getMemoriaDeExecucao().size();
            adicionarRA(controlo);
            controlo.setEvp(newEvp);
        }
    }

    @Override
    public String toString() {
        return "Locals{" +
                "argumentos=" + argumentos +
                ", variaveis=" + variaveis +
                '}';
    }
}