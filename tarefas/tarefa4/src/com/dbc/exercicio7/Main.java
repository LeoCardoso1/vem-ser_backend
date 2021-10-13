package com.dbc.exercicio7;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Qual nome do produto?");
        String nomeProduto = leia.nextLine();

        System.out.println("Qual o preco");
        Double valorProduto = leia.nextDouble();
        leia.nextLine();

        ListaPapelaria lista1 = new ListaPapelaria(nomeProduto, valorProduto);

        lista1.listar();

    }


}
