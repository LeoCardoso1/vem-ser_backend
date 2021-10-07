package com.dbc;

import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
//        int[] valores = new int[3];
//
//        valores[0] = 10;
//        valores[1] = 12;
//        valores[2] = 14;
//
//        int soma = valores[0] + valores[1] + valores[2];
//        double media = soma / 3;
//
//        System.out.println("A soma é: " + soma);
//        System.out.println("A média é: " + media);

//        int [][] numeros = new int[2][2];
//
//        numeros[0][0] = 12;
//        numeros[0][1] = 7;
//        numeros[1][0] = 2;
//        numeros[1][1] = 13;
//
//        int somaTodosValores = numeros[0][0] + numeros[0][1] + numeros[1][0] + numeros[1][1];
//        int somaLinha1 = numeros[0][0] + numeros[0][1];
//        int somaLinha2 = numeros[1][0] + numeros[1][1];
//        int subtracao = somaLinha1 - somaLinha2;
//
//        System.out.println("Soma de todos os valores" + somaTodosValores);
//        System.out.println("A soma da primeira linha é: " + somaLinha1);
//        System.out.println("A soma da segunda linha é: " + somaLinha2);
//        System.out.println("A subtração é: " + subtracao);
//
//        System.out.println("Quantos elementos terá o array? ");
//        int tamanho = leia.nextInt();
//        leia.nextLine();
//
//        int[] valores = new int[tamanho];
//
//        for(int i=0; i < valores.length; i++){
//            System.out.println("Qual o valor do " + (i + 1) + "º valor?");
//            int v = leia.nextInt();
//            leia.nextLine();
//            valores[i] = v;
//        }
//
//        int soma = 0;
//
//        for (int valor : valores) {
//            soma += valor;
//        }
//
//        float media = soma / 3;
//
//        System.out.println("A média é: " + media);

        System.out.println("Qual é a palavra? ");
        String palavra = leia.nextLine();

        while (!(palavra.equalsIgnoreCase("fim"))){
            System.out.println("A palavra digitada foi: " + palavra);
            System.out.println("Deseja digitar outra palavra? Digite fim para encerrar. ");
            palavra = leia.nextLine();
        }

        System.out.println("Encerrando o programa");











    }
}
