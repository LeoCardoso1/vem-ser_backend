package com.dbc;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Qual o valor da hora trabalhada?");
        double hT = leia.nextDouble();                          // hT (Hora Trabalhada)

        while(hT < 0){
            System.out.println("Valor precisa ser maior que 0");
            hT = leia.nextDouble();
        }

        System.out.println("Quantas horas normais foram trabalhadas? ");
        int horasNormais = leia.nextInt();

        while(horasNormais < 0){
            System.out.println("Valor precisa ser maior que 0");
            horasNormais = leia.nextInt();
        }

        System.out.println("Quantas horas extras foram trabalhadas? ");
        int horasExtras = leia.nextInt();

        while(horasExtras < 0){
            System.out.println("Valor precisa ser maior que 0");
            horasExtras = leia.nextInt();
        }

        System.out.println("Quantas horas extras noturnas foram trabalhadas? ");
        int horasExtrasNoturnas = leia.nextInt();

        while(horasExtrasNoturnas < 0){
            System.out.println("Valor precisa ser maior que 0");
            horasExtrasNoturnas = leia.nextInt();
        }

        double salario = (horasNormais * hT) + (horasExtras * (hT * 1.5)) + (horasExtrasNoturnas * (hT * 2));

        System.out.printf("O seu salario bruto é: R$ %.2f", salario);
    }
}
