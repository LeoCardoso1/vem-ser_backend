package com.dbc;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Qual o seu nome? ");
        String nome = leia.next();
        leia.nextLine();
        System.out.println("Qual a sua idade? ");
        int idade = leia.nextInt();
        leia.nextLine();
        System.out.println("Qual sua cidade? ");
        String cidade = leia.next();
        leia.nextLine();
        System.out.println("Qual o estado? ");
        String estado = leia.next();

        System.out.println("O seu nome é: " + nome + ", você tem: " + idade + " anos," + " é da cidade de " + cidade +
                " situada no estado de " + estado + "." );

    }
}
