package src;

public class PrintString extends Instrucao {

    private String string;

    public PrintString(String string) {

        this.string = string;

    }

    public String getString() {
        return string;
    }

    @Override
    public void executar() {

    }
}
