package src;

import java.util.ArrayList;
import java.util.Stack;

public class Controlo {

    private ArrayList<Integer> memoriaDeExecucao;
    private Stack<Integer> pilhaDeAvaliacao;
    private int pc, evp;

    public Controlo() {

        memoriaDeExecucao = new ArrayList<>();
        pilhaDeAvaliacao = new Stack<>();
        pc = 0;
        evp = -1;
    }


    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getEvp() {
        return evp;
    }

    public void setEvp(int evp) {
        this.evp = evp;
    }

    public Stack<Integer> getPilhaDeAvaliacao() {
        return pilhaDeAvaliacao;
    }

    public void setPilhaDeAvaliacao(Stack<Integer> pilhaDeAvaliacao) {
        this.pilhaDeAvaliacao = pilhaDeAvaliacao;
    }

    public ArrayList<Integer> getMemoriaDeExecucao() {
        return memoriaDeExecucao;
    }

    public void setMemoriaDeExecucao(ArrayList<Integer> memoriaDeExecucao) {
        this.memoriaDeExecucao = memoriaDeExecucao;
    }
}
