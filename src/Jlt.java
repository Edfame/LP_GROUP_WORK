package src;

public class Jlt extends Instrucao{

    private String etiqueta;

    public Jlt(String etiqueta) {

        this.etiqueta = etiqueta;

    }

    public String getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void executar() {

    }
}
