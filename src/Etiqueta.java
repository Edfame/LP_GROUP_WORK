package src;

public class Etiqueta {

    private String etiqueta;

    public Etiqueta(String etiqueta) {

        this.etiqueta = etiqueta;

    }

    public String getEtiqueta() {
        return etiqueta;
    }

    @Override
    public String toString() {
        return "Etiqueta{" +
                "etiqueta='" + etiqueta + '\'' +
                '}';
    }
}
