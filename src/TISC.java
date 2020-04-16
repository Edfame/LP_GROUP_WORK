package src;
// Tiny Instruction Set Computer

import java.util.ArrayList;

public class TISC {
  /** Executa o programa src.TISC carregado na maquina. */

  private ArrayList<Instrucao> memoriaDeInstrucoes;

  public TISC() {

    memoriaDeInstrucoes = new ArrayList<>();

  }

  public void adionarInstrucao(Instrucao novaInstrucao) {

    memoriaDeInstrucoes.add(novaInstrucao);

  }

  public void printMemoriaDeInstrucoes() {

    memoriaDeInstrucoes.forEach(
            instrucao -> System.out.println(instrucao.getClass())
    );

  }

  public void executa() {

  }

  public static void main(String[] args) {

    TISC t = new TISC();

    t.adionarInstrucao(new Add());
    t.adionarInstrucao(new Sub());
    t.adionarInstrucao(new SetArg(5));
    t.adionarInstrucao(new Return());

    t.printMemoriaDeInstrucoes();
  }
}
