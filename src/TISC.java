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

    /**
     * Adiciona uma nova Instrução à memória de instruções.
     *
     * @param novaInstrucao instrução a ser adicionada.
     */
    public void adionarInstrucao(Instrucao novaInstrucao) {

        memoriaDeInstrucoes.add(novaInstrucao);
        numeroDeInstrucoes++;

    }

    /**
     * Adiciona uma nova Etiqueta à HashTable das mesmas.
     *
     * @param novaEtiqueta Etiqueta a ser adicionada.
     */
    public void adicionarEtiqueta(Etiqueta novaEtiqueta) {

        etiquetas.put(novaEtiqueta, numeroDeInstrucoes);

    }

    /**
     * Percorre a memória de instruções e escreve no standard output as instruções e os respectivos argumentos.
     */
    public void printMemoriaDeInstrucoes() {

        for (int i = 0; i < memoriaDeInstrucoes.size(); i++) {
            System.out.println(i + ": " + memoriaDeInstrucoes.get(i));
        }
    }

    /**
     * Escreve no standard output as Etiquetas presentes no progreama e as posições da instrução para a qual apontam.
     */
    public void printEtiquetas() {

        System.out.println(etiquetas.toString());
    }

    /**
     * Dado o número de um bloco, devolve o valor do CL do mesmo.
     */
    private int getCL(int evp) {
        return memoriaDeExecucao.get(evp);
    }

    /**
     * Dado o número de um bloco, devolve o valor do AL do mesmo.
     */
    private int getAL(int evp) {
        return memoriaDeExecucao.get(evp + 1);
    }

    /**
     * Dado o número de um bloco, devolve o valor do ER do mesmo.
     */
    private int getER(int evp) {
        return memoriaDeExecucao.get(evp + 2);
    }

    /**
     * Dado o número de um bloco, devolve o valor do Numero de Argumentos do mesmo.
     */
    private int getNumeroArgumentos(int evp) {
        return memoriaDeExecucao.get(evp + 3);
    }

    /**
     * Dado o número de um bloco, devolve o valor do Numero de Variáveis do mesmo.
     */
    private int getNumeroInstrucoes(int evp) {
        return memoriaDeExecucao.get(evp + 4);
    }

    /*
     * Instruções
     */

    /**
     * Empilha na pilha de avaliação o valor do argumento em numero cuja profundidade do bloco é distancia.
     *
     * @param distancia distancia do bloco onde se encontra o argumento.
     * @param numero    poscição do argumento a alterar.
     */
    public void pushArg(int distancia, int numero) {

        int ra = evp;

        for (int i = distancia; i > 0; i--) {

            ra = getAL(ra);

        }

        pilhaDeAvaliacao.push(memoriaDeExecucao.get(ra + CL_AL_ER_A_V - 1 + numero));
    }

    /**
     * Desempilha da pilha de avaliação o valor do topo e coloca-o no argumento cuja posição é numero e cuja profundidade do bloco onde este está corresponde a distancia.
     *
     * @param distancia distancia do bloco onde se encontra o argumento.
     * @param numero    poscição do argumento a ser alterado.
     */
    public void storeArg(int distancia, int numero) {

        int ra = evp;

        for (int i = distancia; i > 0; i--) {

            ra = getAL(ra);

        }

        memoriaDeExecucao.set(ra + CL_AL_ER_A_V - 1 + numero, pilhaDeAvaliacao.pop());

    }

    /**
     * Retira os dois elementos no topo da pilha
     * e empilha a soma dos mesmos.
     */
    public void add() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push(direita + esquerda);
    }

    /**
     * Retira os dois elementos no topo da pilha
     * e empilha a divisão dos mesmos.
     */
    public void div() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push(esquerda / direita);
    }

    /**
     * Retira os dois elementos no topo da pilha
     * e efetua a operação de exponenciação entre eles.
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
     * e empilha a multiplicação dos mesmos.
     */
    public void mult() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push(direita * esquerda);
    }

    /**
     * Retira os dois elementos no topo da pilha
     * e empilha a subtração dos mesmos.
     */
    public void sub() {

        int direita = pilhaDeAvaliacao.pop();
        int esquerda = pilhaDeAvaliacao.pop();

        pilhaDeAvaliacao.push(esquerda - direita);
    }

    /**
     * Chama a função cuja declaração está à profundidade distancia e é identificada por etiqueta.
     *
     * @param distancia profundidade da declaração da função chamada relativamente à função chamadora.
     * @param etiqueta Etiqueta que identifica a função a ser chamada.
     */
    public void call(int distancia, Etiqueta etiqueta) {

        pc1 = this.pc + 1;
        distanciaCall = distancia;

        jump(etiqueta);

    }

    /**
     * Cria um novo Registo de Ativação(RA) com o número de argumentos e de variáveis iguais a argumentos e variávies respectivamente.
     *
     * @param argumentos numero de argumentos do RA.
     * @param variaveis numero de variaveis do RA.
     */
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

            int numeroArgumentosAtual = getNumeroArgumentos(evp),
                numeroVariaveisAtual = getNumeroInstrucoes(evp);

            //CL
            memoriaDeExecucao.add(evp);

            //AL
            if (distanciaCall < 0) {

                //AL é igual ao evp.
                memoriaDeExecucao.add(evp);

            } else {

                int tempEvp = getAL(evp);

                for (int i = distanciaCall; i > 0; i--) {
                    tempEvp = getAL(tempEvp);
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
     * Faz o environment pointer apontar para o Registo de Ativação anterior.
     */
    public void returnInst() {

        int tempEvp;

        pc = evp == 0 ? memoriaDeInstrucoes.size() : getER(evp) - 1;

        try {
            tempEvp = getCL(evp);
        } catch (NullPointerException e) {
            tempEvp = -1;
        }

        for (int i = memoriaDeExecucao.size() - 1; i >= evp; i--) {
            memoriaDeExecucao.remove(i);
        }

        evp = tempEvp;
    }

    /**
     * Coloca o argumento numero numa posição acessível à função que irá ser chamada.
     *
     * @param numero posicção do argumento a ser alterado.
     */
    public void setArg(int numero) {

        //Preencher a lista com null para que não dê exceção ao acedar a uma posição previamente não alocada.
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
     * Coloca no standard out o valor que está no topo da pilha.
     */
    public void print() {

        System.out.print(pilhaDeAvaliacao.pop());
    }

    /**
     * Coloca no standard out "\n".
     */
    public void printNl() {

        System.out.print("\n");
    }

    /**
     * Coloca no standard out a string passada.
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
     * Salta para a posição a que etiqueta refere.
     *
     * @param etiqueta aponta para a instrução para onde saltar.
     */
    public void jump(Etiqueta etiqueta) {

        pc = etiquetas.get(etiqueta) - 1;

    }

    /**
     * Dada uma distância de um RA e a posição (numero) de uma variavel no mesmo,
     * o seu valor é empilhado na pilha de avaliação.
     *
     * @param distancia profundidade do RA relativamente ao RA atual.
     * @param numero posição do RA onde se encontra a variável.
     */
    public void pushVar(int distancia, int numero) {

        int ra = evp,
                numeroArgumentos;

        for (int i = distancia; i > 0; i--) {

            ra = getAL(ra);

        }

        numeroArgumentos = getNumeroArgumentos(ra);
        pilhaDeAvaliacao.push(memoriaDeExecucao.get(ra + CL_AL_ER_A_V - 1 + numeroArgumentos + numero));
    }

    /**
     * Dada uma distância de um RA e a posição (numero) de uma variável no mesmo,
     * desempilha o valor do topo da pilha de avaliação e coloca-o na posição da variável.
     *
     * @param distancia profundidade do RA relativamente ao RA atual.
     * @param numero posição do RA onde se encontra a variável.
     */
    public void storeVar(int distancia, int numero) {

        int ra = evp,
                numeroArgumentos;

        for (int i = distancia; i > 0; i--) {

            ra = memoriaDeExecucao.get(ra + 1);

        }

        numeroArgumentos = getNumeroArgumentos(ra);
        memoriaDeExecucao.set(ra + CL_AL_ER_A_V - 1 + numeroArgumentos + numero, pilhaDeAvaliacao.pop());
    }

    /**
     * Executa o programa TISC carregado na maquina.
     */
    public void executa() {

        /*
        printMemoriaDeInstrucoes();
        printEtiquetas();
        */

        //O programa inicia-se na etiqueta "program".
        this.pc = etiquetas.get(new Etiqueta("program"));

        //Lê o programa da memória e executá-lo.
        while (this.pc < memoriaDeInstrucoes.size()) {

            memoriaDeInstrucoes.get(pc).executar(this);
            pc++;

        }
    }
}
