package src.saltos;

import src.Controlo;
import src.Etiqueta;
import src.Instrucao;

public class Jeq extends Instrucao {

    private Etiqueta etiqueta;

    public Jeq(Etiqueta etiqueta) {

        this.etiqueta = etiqueta;

    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void executar(Controlo controlo) {

        int a = controlo.getPilhaDeAvaliacao().pop();
        int b = controlo.getPilhaDeAvaliacao().pop();

        if (a == b) {

            controlo.setPc(etiqueta.getPosicao());

        }
    }

    @Override
    public String toString() {
        return "Jeq{" +
                "etiqueta=" + etiqueta +
                '}';
    }
}
