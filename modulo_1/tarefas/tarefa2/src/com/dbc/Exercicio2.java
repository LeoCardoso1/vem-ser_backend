// 2. Isso lembrará uma brincadeira de colégio...Uma pessoa escolhe um número e pede
//para outro adivinhar, faça um programa que tenha a mesma ideia, você informará um
//número e quando alguém for tentar adivinhá-lo o programa deverá informar se
//acertou o número ou se errou, se errou o programa deverá apresentar uma das
//seguintes frases: O número a ser encontrado é menor do que você digitou ou O
//número a ser encontrado é maior do que você digitou

package com.dbc;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Jogador 1, qual número você escolhe?");
        int escolhaPrimeiro = leia.nextInt();
        leia.nextLine();

        for(int i = 0; i < 5; i++){
            System.out.println("*********************");
        }

        System.out.println("Hora do jogador 2 jogar!!!");
        int tentativa = 0;

        while (tentativa < 4){
            System.out.println((tentativa + 1) + "ª chance, qual o número do jogador 1?");
            int resposta = leia.nextInt();
            leia.nextLine();
            tentativa++;
            if(resposta < escolhaPrimeiro)
                System.out.println("É um numero maior que " + resposta);
            else if(resposta > escolhaPrimeiro)
                System.out.println("É um numero menor que " + resposta);
            else {
                System.out.println("Você acertou!!!");
                break;
            }
        }

        if(tentativa == 4){
            System.out.println("Acabou suas chances :(");
        }


    }
}
