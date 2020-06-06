package src.saltos;

import src.Etiqueta;
import src.Instrucao;
import src.TISC;

public class Jlt extends Instrucao {

    private Etiqueta etiqueta;

    public Jlt(Etiqueta etiqueta) {

        this.etiqueta = etiqueta;

    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void executar(TISC tisc) {

        tisc.jlt(etiqueta);

    }

    @Override
    public String toString() {
        return "Jlt{" +
                "etiqueta=" + etiqueta +
                '}';
    }
}
