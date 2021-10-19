package com.dbc.exercicio6;

import java.awt.*;

public class Tradutor {
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    String [] portugues = {"cachorro", "tempo", "amor", "cidade", "feliz"};
    String [] ingles = {"dog", "time", "love", "city", "happy"};
    int opcao;


    public Tradutor(int opcao) {
        this.opcao = opcao;
    }


    public void traduzir(String palavra){
        int indice = -1;

        if (opcao == 0){
            for (int i = 0; i < portugues.length;i++){
                if(palavra.equalsIgnoreCase(portugues[i])){
                    indice = i;
                    break;
                }
            }
            if (indice == -1)
                System.out.println("Palavra não encontrada no banco de dados");
            else
                System.out.println("A tradução é: " + ANSI_BLUE + ingles[indice] + ANSI_RESET);
        }
        else {
            for (int i = 0; i < ingles.length;i++){
                if(palavra.equalsIgnoreCase(ingles[i])){
                    indice = i;
                    break;
                }
            }
            if (indice == -1)
                System.out.println("Palavra não encontrada no banco de dados");
            else
                System.out.println("A tradução é:" + ANSI_BLUE + portugues[indice] + ANSI_RESET);
        }
    }
}
