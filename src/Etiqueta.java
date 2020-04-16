package src;

public class Etiqueta extends Instrucao{

    private String etiqueta;

    public Etiqueta(String etiqueta) {

        this.etiqueta = etiqueta;

    }

    public String getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void executar() {

    }
}
