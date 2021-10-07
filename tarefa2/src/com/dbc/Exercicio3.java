// 3. Desenvolver um algoritmo que peça nome, altura, idade, peso dos jogadores de
//basquete, enquanto o nome do jogador for diferente da palavra SAIR o programa
//deverá pedir essas informações, após cadastrados deverá aparecer as seguintes
//informações:
//Quantidade de jogadores cadastrados;
//Altura do maior Jogador;
//Jogador mais velho;
//Jogador mais pesado;
//Média das alturas jogadores.

package com.dbc;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Quantos jogadores serão inseridos?");  // O usuário dirá quantos jogadores serão cadastrados
        int qtd = leia.nextInt();
        leia.nextLine();

        String[] nomes = new String[qtd];
        double[][] jogadores = new double[3][qtd];


        for (int j = 0; j < qtd; j++) {
            System.out.println("Qual o nome do " + (j + 1) + "º jogador?");
            nomes[j] = leia.nextLine();
            System.out.println("Qual a altura do " + (j + 1) + "º jogador?");
            jogadores[0][j] = leia.nextDouble();
            leia.nextLine();
            System.out.println("Qual a idade do " + (j + 1) + "º jogador?");
            jogadores[1][j] = leia.nextDouble();
            leia.nextLine();
            System.out.println("Qual o peso do " + (j + 1) + "º jogador?");
            jogadores[2][j] = leia.nextDouble();
            leia.nextLine();
        }

        double maiorAltura = 0;
        int indiceMaiorAltura = 0;
        for(int j = 0; j < qtd; j++){
            if (jogadores[0][j] > maiorAltura) {
                maiorAltura = jogadores[0][j];
                indiceMaiorAltura = j;
            }
        }

        double maisVelho = 0;
        int indiceMaisVelho = 0;
        for(int j = 0; j < qtd; j++) {
            if (jogadores[1][j] > maisVelho)
                maisVelho = jogadores[1][j];
                indiceMaisVelho = j;
            }

        double maisPesado = 0;
        int indiceMaisPesado = 0;
        for(int j = 0; j < qtd; j++){
            if (jogadores[2][j] > maisPesado)
                maisPesado = jogadores[2][j];
                indiceMaisPesado = j;
        }

        int somaAlturas = 0;

        for(int j = 0; j < qtd; j++){
            somaAlturas += jogadores[0][j];
        }

        float media = somaAlturas / qtd;

        System.out.println("O número de jogadores cadastrados foi: " +qtd);
        System.out.println("O jogador com maior altura é " + nomes[indiceMaiorAltura] + " com " + maiorAltura);
        System.out.println("O jogador mais velho é " + nomes[indiceMaiorAltura] + " com " + maisVelho);
        System.out.println("O jogador mais pesado é " + nomes[indiceMaisPesado] + " com " + maisPesado);
        System.out.println("A média da altura é " + media);






    }

    }

