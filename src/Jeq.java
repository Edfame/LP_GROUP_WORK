package src;

public class Jeq extends Instrucao {

    private Etiqueta etiqueta;

    public Jeq(Etiqueta etiqueta) {

        this.etiqueta = etiqueta;

    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void executar() {

    }
}
