package com.dbc.exercicio13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        Matriz matrizUsuario = new Matriz();

        int cont = 1;
        double num;

        int[] valores = new int[2];

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                System.out.println("Digite o " + cont + "º número");
                num = leia.nextDouble();
                leia.nextLine();
                matrizUsuario.preenchendoMatriz(i, j, num);
                cont++;
            }
        }

        matrizUsuario.conferindoMaioresQueDez();
    }
}
