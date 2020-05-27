package src;

public class Etiqueta {

    private String etiqueta;
    private int posicao;

    public Etiqueta(String etiqueta) {

        this.etiqueta = etiqueta;

    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @Override
    public String toString() {
        return "Etiqueta{" +
                "etiqueta='" + etiqueta + '\'' +
                '}';
    }
}
