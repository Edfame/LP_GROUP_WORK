package src;

public class Jump extends Instrucao {

    private Etiqueta etiqueta;

    public Jump(Etiqueta etiqueta) {

        this.etiqueta = etiqueta;
    }

    public Etiqueta getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void executar() {

    }
}
