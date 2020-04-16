package src;

public class SetArg extends Instrucao {

    private int numero;

    public SetArg(int numero) {

        this.numero = numero;

    }

    public int getNumero() {
        return numero;
    }

    @Override
    public void executar() {

    }
}