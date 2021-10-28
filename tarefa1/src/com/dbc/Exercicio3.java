package com.dbc;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        System.out.println("Digite o valor consumido: ");
        double valorConsumido = leia.nextDouble();
        leia.nextLine();
        System.out.println("Digite o valor pago: ");
        double valorPago = leia.nextDouble();
        leia.nextLine();

        if(valorPago < valorConsumido){
            System.out.println("O valor pago deve ser igual ou maior ao consumido.");
        }else{
            double troco = valorPago - valorConsumido;
            System.out.printf("O seu troco é: R$ %.2f", troco);
        }
    }
}
