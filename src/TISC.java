package src;
// Tiny Instruction Set Computer

import src.aritmeticas.Add;
import src.aritmeticas.Sub;
import src.funcoes.Call;
import src.funcoes.Return;
import src.funcoes.SetArg;
import src.saltos.Jump;

import java.util.ArrayList;
import java.util.Hashtable;

public class TISC {

    private ArrayList<Instrucao> memoriaDeInstrucoes;
    private Hashtable<Etiqueta, Integer> etiquetas;
    private int numberOfInstructions;

    /*
     * Cria um novo objeto da máquina TISC.
     */
    public TISC() {

        memoriaDeInstrucoes = new ArrayList<>();
        etiquetas = new Hashtable<>();
        numberOfInstructions = 0;

    }

    /*
     * Adiciona uma nova Instrução à memória de instruções.
     */
    public void adionarInstrucao(Instrucao novaInstrucao) {

        memoriaDeInstrucoes.add(novaInstrucao);
        numberOfInstructions++;

    }

    /*
     * Adiciona uma nova Etiqueta à HashTable das mesmas.
     */
    public void adicionarEtiqueta(Etiqueta novaEtiqueta) {

        etiquetas.put(novaEtiqueta, numberOfInstructions);

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

        //TODO ler o programa da memória e executá-lo.
    }

    public static void main(String[] args) {

        TISC t = new TISC();

        t.adionarInstrucao(new Add());
        t.adicionarEtiqueta(new Etiqueta("INICIO"));
        t.adionarInstrucao(new Sub());
        t.adionarInstrucao(new SetArg(5));
        t.adicionarEtiqueta(new Etiqueta("FUNC"));
        t.adionarInstrucao(new Return());
        t.adionarInstrucao(new Call(5, new Etiqueta("FUNC")));
        t.adionarInstrucao(new Jump(new Etiqueta("INICIO")));

        t.printMemoriaDeInstrucoes();
        t.printEtiquetas();
    }
}
