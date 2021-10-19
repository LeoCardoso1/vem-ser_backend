package com.dbc.exercicio12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        Busca busca = new Busca();

        System.out.println("Qual número deseja conferir? Digite zero para sair");
        int res = leia.nextInt();

        while (res != 0){
            busca.imprimeSeContemNumero(res);
            System.out.println("Qual número deseja conferir? Digite zero para sair");
            res = leia.nextInt();
        }
        System.out.println("Obrigado por usar o programa :D");
    }
}