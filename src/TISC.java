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

    /**
     * Retira os dois elementos no topo da pilha
     * e empilha a soma dos dois.
     */
    public void add() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push(direita + esquerda);
    }

    /**
     * Retira os dois elementos no topo da pilha
     * e empilha a divisão dos dois.
     */
    public void div() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push(esquerda / direita);
    }

    /**
     * Retira os dois elementos no topo da pilha
     * e efetua a operação de pontenciação.
     */
    public void exp() {

        int expoente = pilhaDeAvaliacao.pop();
        int base = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push((int) Math.pow(base, expoente));
    }

    /**
     * Retira os dois elementos no topo da pilha
     * e empilha o módulo da divisão dos dois.
     */
    public void mod() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push(esquerda % direita);
    }

    /**
     * Retira os dois elementos no topo da pilha
     * e empilha a multiplicação dos dois.
     */
    public void mult() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push(direita * esquerda);
    }

    /**
     * Retira os dois elementos no topo da pilha
     * e empilha a subtração dos dois.
     */
    public void sub() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push(esquerda - direita);
    }

    public void call(int distancia, Etiqueta etiqueta) {
    }

    public void locals(int argumentos, int variaveis) {
    }

    /**
     * Faz o environment pointer apontar para o Registo de Ativação anterior .
     */
    public void returnInst() {

        evp = memoriaDeExecucao.get(evp);

    }

    public void setArg(int numero) {
    }

    /**
     * Empilha o inteiro dado no topo da pilha.
     *
     * @param inteiro número a ser empilhado.
     */
    public void pushInt(int inteiro) {

        pilhaDeAvaliacao.push(inteiro);
    }

    /**
     * Coloca no standart out o valor que está no topo da pilha.
     */
    public void print() {

        System.out.print(pilhaDeAvaliacao.pop());
    }

    /**
     * Coloca no standart out "\n".
     */
    public void printNl() {

        System.out.print("\n");
    }

    /**
     * Coloca no standart out a string passada.
     *
     * @param string valor que é imprimido.
     */
    public void printString(String string) {

        System.out.print(string);
    }

    /**
     * Salta para a etiqueta caso os valores no
     * topo da pilha sejam iguais.
     *
     * @param etiqueta aponta para a instrução para onde saltar.
     */
    public void jeq(Etiqueta etiqueta) {

        int a = pilhaDeAvaliacao.pop();
        int b = pilhaDeAvaliacao.pop();

        if (a == b) {

            pc = etiquetas.get(etiqueta);

        }
    }

    /**
     * Seja A o valor no topo da pilha e B o seguinte,
     * salta para a etiqueta caso B < A.
     *
     * @param etiqueta aponta para a instrução para onde saltar.
     */
    public void jlt(Etiqueta etiqueta) {

        int a = pilhaDeAvaliacao.pop();
        int b = pilhaDeAvaliacao.pop();

        if (a > b) {

            pc = etiquetas.get(etiqueta);

        }
    }

    /**
     * Salta para a etiqueta.
     *
     * @param etiqueta aponta para a instrução para onde saltar.
     */
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
