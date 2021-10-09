//8. Faça um programa que leia uma matriz de 5x4 inteiros contendo as seguintes
//        informações do tipo inteiro:
//        a. Primeira coluna: número da matrícula
//        b. Segunda coluna: media das provas
//        c. Terceira coluna: média dos trabalhos
//        d. Quarta coluna: nota final
//Elabore um programa que:
//        a. Leia as 3 primeiras informações de cada aluno
//        b. Calcule a nota final = (media das provas * 0,6 + media dos trabalhos * 0,4)
//        c. Imprima a matrícula que obteve a maior nota final
//        d. Imprima a média das notas finais

package com.dbc;

import java.util.Scanner;

public class Exercicio8 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        double [][] alunos = {
                {300, 8, 7, 0},
                {301, 9, 8, 0},
                {302, 6, 6, 0},
                {303, 7.5, 7.8, 0},
                {304, 8, 7.5, 0 }};
        // As matrículas começam em 300, e a nota final foi setada como zero, mudei para double a matriz, invés de int


        for(int i = 0; i < alunos.length; i++){                     // Imprimir informação dos alunos
            System.out.println((i+ 1) + "º aluno: ");
            System.out.println("Número de matrícula: " + alunos[i][0]);
            System.out.println("Média das provas: " + alunos[i][1]);
            System.out.println("Média dos trabalhos: " + alunos[i][2]);
            System.out.println("--------------------------");
        }


        for(int i = 0; i < alunos.length; i++){                    // Calcular nota final
            double notaFinal = (alunos[i][1] * 0.6) + (alunos[i][2] * 0.4);
            alunos[i][3] = notaFinal;
        }


        double maiorNota = 0;
        double matriculaComMaiorNotaFinal = 0;      // Matrícula com maior nota final
        for (int i = 0; i < alunos.length; i++){
            if(alunos[i][3] > maiorNota)
                matriculaComMaiorNotaFinal = alunos[i][0];
        }

        System.out.println("Matrícula com maior nota final: " + matriculaComMaiorNotaFinal);


        double totalNotas = 0;                       // Média das notas finais
        for (int i = 0; i < alunos.length; i++){
            totalNotas += alunos[i][2];
        }

        double mediaNotas = totalNotas / alunos.length;

        System.out.println("Média das notas finais: " + mediaNotas);



    }
}
