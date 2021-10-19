package com.dbc.exercicio11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        Integer [] lista = new Integer[20];

        for(int i = 0; i < 20; i++){
            System.out.println("Digite o " + (i + 1) + " ºnúmero");
            lista[i] = leia.nextInt();
            leia.nextLine();
        }

        Inversao inversao = new Inversao();

        inversao.invertendoNumeros(lista);
    }
}
