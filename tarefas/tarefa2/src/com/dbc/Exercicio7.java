// 7. Leia uma matriz 4 x 4, conte e escreva quantos valores maiores que 10 ela possui

package com.dbc;

import java.util.Scanner;

public class Exercicio7 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        int [][] matriz = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int cont = 0;

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                if((matriz[i][j]) > 10)
                    cont += 1;
            }
        }

        System.out.printf("A quantidade de números maiores que 10 na matriz é: %d ", cont);
    }
}
