package src.saltos;

import src.Etiqueta;
import src.Instrucao;

public class Jlt extends Instrucao {

    private Etiqueta etiqueta;

    public Jlt(Etiqueta etiqueta) {

        this.etiqueta = etiqueta;

    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void executar() {

    }

    @Override
    public String toString() {
        return "Jlt{" +
                "etiqueta=" + etiqueta +
                '}';
    }
}
