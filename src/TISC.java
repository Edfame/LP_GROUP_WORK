package src;

import java.util.ArrayList;
import java.util.Hashtable;

// Tiny Instruction Set Computer
public class TISC {

    private ArrayList<Instrucao> memoriaDeInstrucoes;
    private Hashtable<Etiqueta, Integer> etiquetas;
    private int numeroDeInstrucoes;

    /*
     * Cria um novo objeto da máquina TISC.
     */
    public TISC() {

        memoriaDeInstrucoes = new ArrayList<>();
        etiquetas = new Hashtable<>();
        numeroDeInstrucoes = 0;

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

        printMemoriaDeInstrucoes();
        printEtiquetas();
        //TODO ler o programa da memória e executá-lo.
    }
}
