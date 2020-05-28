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

        int a = tisc.getPilhaDeAvaliacao().pop();
        int b = tisc.getPilhaDeAvaliacao().pop();

        if (a > b) {

            tisc.setPc(tisc.getEtiquetas().get(etiqueta));

        }

    }

    @Override
    public String toString() {
        return "Jlt{" +
                "etiqueta=" + etiqueta +
                '}';
    }
}
