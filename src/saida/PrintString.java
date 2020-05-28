package src.saida;

import src.Instrucao;
import src.TISC;

public class PrintString extends Instrucao {

    private String string;

    public PrintString(String string) {

        this.string = string;

    }

    public String getString() {
        return string;
    }

    @Override
    public void executar(TISC tisc) {

        tisc.printString(string);

    }

    @Override
    public String toString() {
        return "PrintString{" +
                "string='" + string + '\'' +
                '}';
    }
}
