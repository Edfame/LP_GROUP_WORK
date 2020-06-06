package src;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Etiqueta)) return false;
        Etiqueta etiqueta1 = (Etiqueta) o;
        return Objects.equals(getEtiqueta(), etiqueta1.getEtiqueta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEtiqueta());
    }
}
