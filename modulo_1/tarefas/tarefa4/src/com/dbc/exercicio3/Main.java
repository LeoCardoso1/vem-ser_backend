package com.dbc.exercicio3;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Qual total da comanda?");
        Double totalComandaCliente = leia.nextDouble();
        leia.nextLine();

        System.out.println("Qual total pago do cliente?");
        Double totalPago = leia.nextDouble();
        leia.nextLine();

        while (totalPago < totalComandaCliente){
            System.out.println("Dinheiro inválido, menor queo preço da comanda.");
            totalPago = leia.nextDouble();
            leia.nextLine();
        }

        Comanda comanda1 = new Comanda(totalComandaCliente, totalPago);
//        Comanda comanda2 = new Comanda(totalComandaCliente, totalPago);

        comanda1.imprimeDados();
//        comanda2.imprimeDados();


    }



}
