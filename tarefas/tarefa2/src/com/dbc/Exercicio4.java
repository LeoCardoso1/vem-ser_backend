// 4. Desenvolver um algoritmo que peça três números e informe a posição do menor
// número digitado (usar vetor)

package com.dbc;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        int[] numeros = new int[3];

        for(int i = 0; i < numeros.length; i++){
            System.out.println("Qual o " + (i + 1) + " número?");
            numeros[i] = leia.nextInt();
        }

        int menor = numeros[0];
        int indiceMenor = 0;

        for(int i = 0; i < numeros.length; i++){
            if(numeros[i] < menor){
                menor = numeros[i];
                indiceMenor = i;
            }
        }

        System.out.println("O número menor é: " + menor + ", no índice: " + indiceMenor);


    }
}
