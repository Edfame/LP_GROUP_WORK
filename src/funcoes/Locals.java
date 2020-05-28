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

    private void adicionarRA(TISC tisc) {

        tisc.getMemoriaDeExecucao().add(tisc.getEvp());
        tisc.getMemoriaDeExecucao().add(null);
        tisc.getMemoriaDeExecucao().add(null);

        for (int i = 0; i < argumentos + variaveis; i++) {

            tisc.getMemoriaDeExecucao().add(null);
        }
    }

    @Override
    public void executar(TISC tisc) {

        if (tisc.getEvp() == -1) {

            adicionarRA(tisc);
            tisc.setEvp(0);

        } else {

            int newEvp = tisc.getMemoriaDeExecucao().size();
            adicionarRA(tisc);
            tisc.setEvp(newEvp);
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