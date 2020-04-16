package src;

public class Jeq extends Instrucao{

    private String etiqueta;

    public Jeq(String etiqueta) {

        this.etiqueta = etiqueta;

    }

    public String getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void executar() {

    }
}
