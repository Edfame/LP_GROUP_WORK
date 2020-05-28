package src;

public abstract class Instrucao {

    public final int CLALER = 3;

    public abstract void executar(TISC tisc);

    public abstract String toString();
}
