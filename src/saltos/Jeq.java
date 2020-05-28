package src.saltos;

import src.Etiqueta;
import src.Instrucao;
import src.TISC;

public class Jeq extends Instrucao {

    private Etiqueta etiqueta;

    public Jeq(Etiqueta etiqueta) {

        this.etiqueta = etiqueta;

    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void executar(TISC tisc) {

        tisc.jeq(etiqueta);
    }

    @Override
    public String toString() {
        return "Jeq{" +
                "etiqueta=" + etiqueta +
                '}';
    }
}
