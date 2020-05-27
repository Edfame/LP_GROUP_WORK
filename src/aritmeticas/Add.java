package src.aritmeticas;

import src.Controlo;
import src.Instrucao;

import java.util.ArrayList;
import java.util.Stack;

public class Add extends Instrucao {

    public Add() {

    }

    @Override
    public void executar(Controlo controlo) {

        int direita = controlo.getPilhaDeAvaliacao().pop();
        int esquerda = controlo.getPilhaDeAvaliacao().pop();

        controlo.getPilhaDeAvaliacao().push(direita + esquerda);

    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
