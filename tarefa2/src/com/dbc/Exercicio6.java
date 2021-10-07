//6. Desenvolver um vetor que contenha 10 números (não será pedido ao usuário), ao
//colocar um determinado número deverá ser buscado no vetor por aquele número,
//caso não haja será necessário exibir uma mensagem dizendo que não existe aquele
//determinado número digitado

package com.dbc;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        int [] lista = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Digite o número: ");

        int res = leia.nextInt();
        leia.nextLine();
        int cont = 0;

        for (int j : lista) {
            if (res == j)
                System.out.println("O número foi encontrado na lista");
            else
                cont += 1;
        }

        if(cont == 10)
            System.out.println("O número não foi encontrado na lista");





    }
}
