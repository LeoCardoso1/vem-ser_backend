package com.dbc.exercicio2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Qual o nome do aluno? ");
        String nomeAluno = leia.nextLine();

        Double [] notasAluno = new Double[4];

        for(int i = 0; i < 4; i++){
            System.out.println("Qual a " + (i+1) + "ª nota do aluno?");
            notasAluno[i] = leia.nextDouble();
            leia.nextLine();
        }

        Aluno aluno = new Aluno(nomeAluno, notasAluno);

        aluno.imprimeDados();

    }
}
