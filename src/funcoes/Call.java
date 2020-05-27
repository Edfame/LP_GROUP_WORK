package src.funcoes;

import src.Controlo;
import src.Etiqueta;
import src.Instrucao;

public class Call extends Instrucao {

    private int distancia;
    private Etiqueta etiqueta;

    public Call(int distancia, Etiqueta etiqueta) {

        this.distancia = distancia;
        this.etiqueta = etiqueta;

    }

    public int getDistancia() {
        return distancia;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void executar(Controlo controlo) {

    }

    @Override
    public String toString() {
        return "Call{" +
                "distancia=" + distancia +
                ", etiqueta=" + etiqueta +
                '}';
    }
}