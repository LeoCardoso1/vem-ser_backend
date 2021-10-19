package com.dbc;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        System.out.println("Digite a primeira nota: ");
        double nota1 = leia.nextDouble();
        leia.nextLine();
        System.out.println("Digite a segunda nota: ");
        double nota2 = leia.nextDouble();
        leia.nextLine();
        System.out.println("Digite a terceira nota: ");
        double nota3 = leia.nextDouble();
        leia.nextLine();
        System.out.println("Digite a quarta nota: ");
        double nota4 = leia.nextDouble();
        leia.nextLine();

        double media = (nota1 + nota2 + nota3 + nota4) / 4;

        if(media > 0 && media < 5){
            System.out.printf("A média foi: %.1f e o aluno está reprovado.", media);
        }else if(media > 5 && media < 7){
            System.out.printf("A média foi: %.1f e o aluno está em exame.", media);
        }else{
            System.out.printf("A média foi: %.1f e o aluno está aprovado.", media);
        }


    }
}
