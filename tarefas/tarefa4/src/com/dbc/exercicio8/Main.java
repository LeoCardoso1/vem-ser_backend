package com.dbc.exercicio8;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        Integer tentativas = 1;

        System.out.println("Jogador 1, qual número você escolhe?");
        Integer escolhaPrimeiro = leia.nextInt();
        leia.nextLine();

        Adivinhacao adivinhacao = new Adivinhacao(escolhaPrimeiro);

        for(int i = 0; i < 5; i++){
            System.out.println("*********************");
        }

        System.out.println("Hora do jogador 2 jogar!!!\nQual número do jogador 1?\nVocê tem 4 chances para acertar.");


        while(tentativas < 5){
            System.out.println( tentativas + "ª chance:");
            int res = leia.nextInt();
            boolean resultado = adivinhacao.advinhar(res);
            if (!resultado){
                tentativas += 1;
                if (tentativas == 5)
                    System.out.println("Esgotou suas chances :(");
            }else
                tentativas = 5;
        }

    }



}
