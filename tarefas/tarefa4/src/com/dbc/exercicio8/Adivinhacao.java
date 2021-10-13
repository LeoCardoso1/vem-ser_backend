package com.dbc.exercicio8;

import java.awt.*;

public class Adivinhacao {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";

    Integer numero;

    public Adivinhacao(Integer numero) {
        this.numero = numero;
    }

    boolean advinhar(int palpite){
        if (palpite > numero){
            System.out.println(ANSI_BLUE + "É um número menor que: " + ANSI_RESET + palpite);
            return false;
        }else if(palpite < numero){
            System.out.println(ANSI_RED + "É um número maior que: " + ANSI_RESET + palpite);
            return false;
        }else
            System.out.println(ANSI_GREEN + "ACERTOU!!!" + ANSI_RESET);
            return true;
    }
}
