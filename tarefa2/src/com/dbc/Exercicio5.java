//5. Faça um algoritmo que leia 20 valores e os escreva na ordem contrária à que foram
//digitados.

package com.dbc;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        int[] lista = new int[20];


        for(int i = 0; i < lista.length; i++){
            System.out.println("Digite o " + (i+1) + " ºnúmero");
            lista[i] = leia.nextInt();
            leia.nextLine();
        }

        for(int i = lista.length -1; i >= 0; i--){
            System.out.println(lista[i]);
        }
    }
}
