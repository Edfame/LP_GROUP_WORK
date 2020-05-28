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
        memoriaDeExecucao = new ArrayList<>();
        pilhaDeAvaliacao = new Stack<>();
        etiquetas = new Hashtable<>();
        numeroDeInstrucoes = 0;
        pc = 0;
        evp = -1;

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

    /*
    * Instruções
    * */

    public void pushArg(int distancia, int numero) {

    }

    public void storeArg(int distancia, int numero) {
    }

    public void add() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push(direita + esquerda);
    }

    public void div() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push(esquerda / direita);
    }

    public void exp() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push((int) Math.pow(esquerda, direita));
    }

    public void mod() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push(esquerda % direita);
    }

    public void mult() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push(direita * esquerda);
    }

    public void sub() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push(esquerda - direita);
    }

    public void call(int distancia, Etiqueta etiqueta) {
    }

    public void locals(int argumentos, int variaveis) {
    }

    public void returnInst() {
    }

    public void setArg(int numero) {
    }

    public void pushInt(int inteiro) {

        pilhaDeAvaliacao.push(inteiro);
    }

    public void print() {

        System.out.print(pilhaDeAvaliacao.pop());
    }

    public void printNl() {

        System.out.print("\n");
    }

    public void printString(String string) {

        System.out.print(string);
    }

    public void jeq(Etiqueta etiqueta) {

        int a = pilhaDeAvaliacao.pop();
        int b = pilhaDeAvaliacao.pop();

        if (a == b) {

            pc = etiquetas.get(etiqueta);

        }
    }

    public void jlt(Etiqueta etiqueta) {

        int a = pilhaDeAvaliacao.pop();
        int b = pilhaDeAvaliacao.pop();

        if (a > b) {

            pc = etiquetas.get(etiqueta);

        }
    }

    public void jump(Etiqueta etiqueta) {

        pc = etiquetas.get(etiqueta);

    }

    public void pushVar(int distancia, int numero) {
    }

    public void storeVar(int distancia, int numero) {
    }

    /**
     * Executa o programa src.TISC carregado na maquina.
     */
    public void executa() {

        printMemoriaDeInstrucoes();
        printEtiquetas();

        //TODO ler o programa da memória e executá-lo.
        while (this.pc < memoriaDeInstrucoes.size()) {

            memoriaDeInstrucoes.get(pc).executar(this);
            pc++;
        }
    }
}
