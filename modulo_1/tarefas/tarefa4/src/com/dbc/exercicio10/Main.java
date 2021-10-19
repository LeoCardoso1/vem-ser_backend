package com.dbc.exercicio10;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        Integer[] lista = new Integer[3];

        for(int i = 0; i <= 2; i++){
            System.out.println("Digite o " + (i+1) + "º número" );
            int num = leia.nextInt();
            leia.nextLine();
            lista[i] = num;
        }

        MenorDigitado conferencia = new MenorDigitado();

        conferencia.retornarOMenor(lista);

    }
}