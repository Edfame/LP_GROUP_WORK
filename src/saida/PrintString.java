package src.saida;

import src.Instrucao;

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

    @Override
    public String toString() {
        return "PrintString{" +
                "string='" + string + '\'' +
                '}';
    }
}
