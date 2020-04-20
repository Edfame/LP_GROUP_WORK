package src;

public class PushInt extends Instrucao {

    private int inteiro;

    public PushInt(int inteiro) {

        this.inteiro = inteiro;

    }

    public int getInteiro() {
        return inteiro;
    }

    @Override
    public void executar() {

    }
}