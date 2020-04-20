package src;

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
}
