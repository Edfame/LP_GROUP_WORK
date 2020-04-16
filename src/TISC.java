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

  public void executa() {

  }
}
