package src.saltos;

import src.Etiqueta;
import src.Instrucao;
import src.TISC;

public class Jump extends Instrucao {

    private Etiqueta etiqueta;

    public Jump(Etiqueta etiqueta) {

        this.etiqueta = etiqueta;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void executar(TISC tisc) {

        tisc.setPc(tisc.getEtiquetas().get(etiqueta));

    }

    @Override
    public String toString() {
        return "Jump{" +
                "etiqueta=" + etiqueta +
                '}';
    }
}
