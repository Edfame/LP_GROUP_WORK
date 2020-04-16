package src;

public class Call extends Instrucao {

    private int distancia;
    private String etiqueta;

    public Call(int distancia, String etiqueta) {

        this.distancia = distancia;
        this.etiqueta = etiqueta;

    }

    public int getDistancia() {
        return distancia;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    @Override
    public void executar() {

    }
}