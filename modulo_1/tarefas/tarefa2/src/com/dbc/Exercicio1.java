// 1. Elabore um programa para uma papelaria que leia o nome e o valor de um produto.
// Em seguida, faça uma lista de 1 a 10 unidades do produto, sendo que o desconto de
// uma unidade desse produto seja de 5% e de 2 seja 10% de 3 = 15% etc... Até
// alcançar os 50% de desconto

package com.dbc.tarefa2;

import java.util.Scanner;

public class Exercicio1 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Bem-Vindo a papelaria, temos descontos progressivos nos nossos produtos");

        System.out.println("Qual o nome do produto? ");
        String nome = leia.nextLine();

        System.out.println("Qual o preço? ");
        double preco = leia.nextDouble();
        leia.nextLine();

        System.out.println("Qual a quantidade?");
        int quantidade = leia.nextInt();
        leia.nextLine();
        if(quantidade < 1 || quantidade > 10){
            System.out.println("Quantidade tem que ser entre 1 e 10");
            quantidade = leia.nextInt();
            leia.nextLine();
        }

        preco = preco * (1 -(0.05 * quantidade));

        System.out.println("Você comprou " + quantidade + " " + nome +
                            " ,a unidade com desconto: R$ " + preco +
                            ", o valor total é R$ " + (preco * quantidade));


    }
}
