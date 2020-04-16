package src;

public class Jump extends Instrucao {

    private String etiqueta;

    public Jump(String etiqueta) {

        this.etiqueta = etiqueta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void executar() {

    }
}
