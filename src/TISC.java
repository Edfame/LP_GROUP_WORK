package src;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

// Tiny Instruction Set Computer
public class TISC {

    private ArrayList<Instrucao> memoriaDeInstrucoes;
    private ArrayList<Integer> memoriaDeExecucao;
    private Stack<Integer> pilhaDeAvaliacao;
    private Hashtable<Etiqueta, Integer> etiquetas;
    private int numeroDeInstrucoes, pc, evp;

    /*
     * Cria um novo objeto da máquina TISC.
     */
    public TISC() {

        memoriaDeInstrucoes = new ArrayList<>();
        etiquetas = new Hashtable<>();
        numeroDeInstrucoes = 0;
        memoriaDeExecucao = new ArrayList<>();
        pilhaDeAvaliacao = new Stack<>();
        pc = 0;
        evp = -1;

    }

    public ArrayList<Integer> getMemoriaDeExecucao() {
        return memoriaDeExecucao;
    }

    public void setMemoriaDeExecucao(ArrayList<Integer> memoriaDeExecucao) {
        this.memoriaDeExecucao = memoriaDeExecucao;
    }

    public Stack<Integer> getPilhaDeAvaliacao() {
        return pilhaDeAvaliacao;
    }

    public void setPilhaDeAvaliacao(Stack<Integer> pilhaDeAvaliacao) {
        this.pilhaDeAvaliacao = pilhaDeAvaliacao;
    }

    public Hashtable<Etiqueta, Integer> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(Hashtable<Etiqueta, Integer> etiquetas) {
        this.etiquetas = etiquetas;
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

    /*
     * Adiciona uma nova Instrução à memória de instruções.
     */
    public void adionarInstrucao(Instrucao novaInstrucao) {

        memoriaDeInstrucoes.add(novaInstrucao);
        numeroDeInstrucoes++;

    }

    /*
     * Adiciona uma nova Etiqueta à HashTable das mesmas.
     */
    public void adicionarEtiqueta(Etiqueta novaEtiqueta) {

        etiquetas.put(novaEtiqueta, numeroDeInstrucoes);

    }

    /*
     * Percorre a memória de instruções de dá print das instruções dos respectivos argumentos.
     */
    public void printMemoriaDeInstrucoes() {

        for (int i = 0; i < memoriaDeInstrucoes.size(); i++) {
            System.out.println(i + ": " + memoriaDeInstrucoes.get(i));
        }
    }

    public void printEtiquetas() {

        System.out.println(etiquetas.toString());
    }

    /** Executa o programa src.TISC carregado na maquina. */
    public void executa() {

//        printMemoriaDeInstrucoes();
//        printEtiquetas();
//        //TODO ler o programa da memória e executá-lo.

        for (Instrucao inst: memoriaDeInstrucoes) {

            inst.executar(this);

        }
    }

}
