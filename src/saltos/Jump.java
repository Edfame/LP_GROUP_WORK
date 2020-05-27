package src.saltos;

import src.Controlo;
import src.Etiqueta;
import src.Instrucao;

public class Jump extends Instrucao {

    private Etiqueta etiqueta;

    public Jump(Etiqueta etiqueta) {

        this.etiqueta = etiqueta;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void executar(Controlo controlo) {

        controlo.setPc(etiqueta.getPosicao());

    }

    @Override
    public String toString() {
        return "Jump{" +
                "etiqueta=" + etiqueta +
                '}';
    }
}
