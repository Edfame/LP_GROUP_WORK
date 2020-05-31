package src;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Stack;

// Tiny Instruction Set Computer
public class TISC {

    //Variaveis da máquina com as quais as instruções interegem.
    private ArrayList<Instrucao> memoriaDeInstrucoes;
    private ArrayList<Integer> memoriaDeExecucao;
    private ArrayList<Integer> argumentos;
    private Stack<Integer> pilhaDeAvaliacao;
    private Hashtable<Etiqueta, Integer> etiquetas;
    private int numeroDeInstrucoes, pc, evp, pc1, distanciaCall;

    //Espaço ocupado pelo Control Link, Access Link, Endereço de Retorno, Argumentos e Variávies.
    public final int CL_AL_ER_A_V = 5;

    /*
     * Cria um novo objeto da máquina TISC.
     */
    public TISC() {

        memoriaDeInstrucoes = new ArrayList<>();
        memoriaDeExecucao = new ArrayList<>();
        argumentos = new ArrayList<>();
        pilhaDeAvaliacao = new Stack<>();
        etiquetas = new Hashtable<>();
        numeroDeInstrucoes = 0;
        pc = 0;
        evp = -1;
        pc1 = 0;
        distanciaCall = -1;

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
     *
     */

    /**
     * Empilha na pilha de avaliação o valor do argumento em numero cuja profundidade do bloco é distancia.
     *
     * @param distancia distancia do bloco onde se encontra o argumento
     * @param numero    poscição do argumento
     */
    public void pushArg(int distancia, int numero) {

        int ra = evp;

        for (int i = distancia; i > 0; i--) {

            ra = memoriaDeExecucao.get(ra + 1);

        }

        pilhaDeAvaliacao.push(memoriaDeExecucao.get(ra + CL_AL_ER_A_V - 1 + numero));
    }

    /**
     * Desempilha da pilha de avaliação o valor do topo e coloca-o no argumento cuja posição é numero e cuja profundidade do bloco onde este está corresponde a distancia.
     *
     * @param distancia distancia do bloco onde se encontra o argumento
     * @param numero    poscição do argumento
     */
    public void storeArg(int distancia, int numero) {

        int ra = evp;

        for (int i = distancia; i > 0; i--) {

            ra = memoriaDeExecucao.get(ra + 1);

        }

        memoriaDeExecucao.set(ra + CL_AL_ER_A_V - 1 + numero, pilhaDeAvaliacao.pop());

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

    //TODO review
    public void call(int distancia, Etiqueta etiqueta) {

        //memExec.get(memExec.get(evp) + 1) //AL anterior
        pc1 = this.pc + 1;
        distanciaCall = distancia;

        jump(etiqueta);

    }

    //TODO review
    public void locals(int argumentos, int variaveis) {

        if (evp == -1) {

            evp++;

            for (int i = 0; i < CL_AL_ER_A_V - 2; i++) {
                memoriaDeExecucao.add(null);
            }

            //NUMERO DE ARGUMENTOS
            memoriaDeExecucao.add(argumentos);

            //NUMERO DE VARIAVEIS
            memoriaDeExecucao.add(variaveis);

            for (int i = 0; i < argumentos + variaveis; i++) {
                memoriaDeExecucao.add(null);
            }

        } else {

            int numeroArgumentosAtual = memoriaDeExecucao.get(evp + 3),
                numeroVariaveisAtual = memoriaDeExecucao.get(evp + 4);

            //CL
            memoriaDeExecucao.add(evp);

            //AL
            if (distanciaCall < 0) {

                //AL é igual ao evp.
                memoriaDeExecucao.add(evp);

            } else  {

                int tempEvp = memoriaDeExecucao.get(evp + 1);

                for (int i = distanciaCall; i > 0; i--) {
                    tempEvp = memoriaDeExecucao.get(tempEvp + 1);
                }

                //AL do bloco que dista distanciaCall.
                memoriaDeExecucao.add(tempEvp);

            }

            evp = evp + CL_AL_ER_A_V + numeroArgumentosAtual + numeroVariaveisAtual;

            //ER
            memoriaDeExecucao.add(pc1);

            //NUMERO DE ARGUMENTOS
            memoriaDeExecucao.add(argumentos);

            //NUMERO DE VARIAVEIS
            memoriaDeExecucao.add(variaveis);

            for (int i = 0; i < argumentos + variaveis; i++) {
                memoriaDeExecucao.add(null);
            }

            if (!this.argumentos.isEmpty()) {
                for (int i = 1; i < this.argumentos.size(); i++) {
                    memoriaDeExecucao.set(i + evp + CL_AL_ER_A_V - 1, this.argumentos.get(i));
                }
            }

            this.argumentos.clear();
        }
    }

    /**
     * Faz o environment pointer apontar para o Registo de Ativação anterior .
     */
    public void returnInst() {

        pc = evp == 0 ? memoriaDeInstrucoes.size() : memoriaDeExecucao.get(evp + 2) - 1;

        try {
            evp = memoriaDeExecucao.get(evp);
        } catch(NullPointerException e) {
            evp = -1;
        }

    }

    /**
     * Colocar o argumento numero numa posição acessível à função que vai ser chamada.
     *
     * @param numero posicção do argumento a ser alterado.
     */
    public void setArg(int numero) {

        //Preencher a lista com null para que n dê exceção a acedar a uma posição não previamente alocada.
        for (int i = 0; i <= numero; i++) {

            try {
                this.argumentos.get(i);
            } catch (NullPointerException | IndexOutOfBoundsException e) {
                this.argumentos.add(null);
            }
        }

        argumentos.set(numero, pilhaDeAvaliacao.pop());

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

            pc = etiquetas.get(etiqueta) - 1;

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

            pc = etiquetas.get(etiqueta) - 1;

        }
    }

    /**
     * Salta para a etiqueta.
     *
     * @param etiqueta aponta para a instrução para onde saltar.
     */
    public void jump(Etiqueta etiqueta) {

        pc = etiquetas.get(etiqueta) - 1;

    }

    //TODO
    public void pushVar(int distancia, int numero) {

        int ra = evp,
                numeroArgumentos;

        for (int i = distancia; i > 0; i--) {

            ra = memoriaDeExecucao.get(ra + 1);

        }

        numeroArgumentos = memoriaDeExecucao.get(ra + 3);
        pilhaDeAvaliacao.push(memoriaDeExecucao.get(ra + CL_AL_ER_A_V - 1 + numeroArgumentos + numero));
    }

    //TODO
    public void storeVar(int distancia, int numero) {

        //caso distancia == 0, evp + CL_AR_ER_A_V + memExec.get(evp + 3) + numero
        //else? distancia pode ser pos e neg?

        int ra = evp,
                numeroArgumentos;

        for (int i = distancia; i > 0; i--) {

            ra = memoriaDeExecucao.get(ra + 1);

        }

        numeroArgumentos = memoriaDeExecucao.get(ra + 3);
        memoriaDeExecucao.set(ra + CL_AL_ER_A_V - 1 + numeroArgumentos + numero, pilhaDeAvaliacao.pop());
    }

    /**
     * Executa o programa src.TISC carregado na maquina.
     */
    public void executa() {

        printMemoriaDeInstrucoes();
        printEtiquetas();

//        System.out.println(this.pc);
//        System.out.println(memoriaDeInstrucoes.size());
//        System.out.println(etiquetas.get(new Etiqueta("program")));
        //TODO ler o programa da memória e executá-lo.
        this.pc = etiquetas.get(new Etiqueta("program"));
        while (this.pc < memoriaDeInstrucoes.size()) {

//            System.out.println(memoriaDeInstrucoes.get(pc));
            memoriaDeInstrucoes.get(pc).executar(this);

//            System.out.println("\tPILHA: " + pilhaDeAvaliacao.toString());
//            System.out.println("\tEXEC: " + memoriaDeExecucao.toString());
            pc++;
        }
    }
}
