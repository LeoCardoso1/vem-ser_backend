package com.dbc;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("""
                Seja bem-vindo ao nosso tradutor
                Escolha uma opção:
                1- Inglês para Português
                2- Português para Inglês""");

        int resposta = leia.nextInt();
        leia.nextLine();

        while (resposta < 1 || resposta > 2){
            System.out.println("Resposta inválida, digite 1 ou 2");
            resposta = leia.nextInt();
            leia.nextLine();
        }

        if (resposta == 1){
            System.out.println("Digite a palavra que gostaria de traduzir: ");
            String palavra = leia.nextLine();

            if(palavra.equalsIgnoreCase("dog"))
                System.out.println("A palavra traduzida é cachorro");
            else if(palavra.equalsIgnoreCase("time"))
                System.out.println("A palavra traduzida é tempo");
            else if(palavra.equalsIgnoreCase("love"))
                System.out.println("A palavra traduzida é amor");
            else if(palavra.equalsIgnoreCase("city"))
                System.out.println("A palavra traduzida é cidade");
            else if(palavra.equalsIgnoreCase("happy"))
                System.out.println("A palavra traduzida é feliz");
            else
                System.out.println("Palavra não encontrada em nosso banco de dados.");
        }else{
            System.out.println("Digite a palavra que gostaria de traduzir: ");
            String palavra = leia.nextLine();

            if(palavra.equalsIgnoreCase("cachorro"))
                System.out.println("A palavra traduzida é dog");
            else if(palavra.equalsIgnoreCase("tempo"))
                System.out.println("A palavra traduzida é time");
            else if(palavra.equalsIgnoreCase("amor"))
                System.out.println("A palavra traduzida é love");
            else if(palavra.equalsIgnoreCase("cidade"))
                System.out.println("A palavra traduzida é city");
            else if(palavra.equalsIgnoreCase("feliz"))
                System.out.println("A palavra traduzida é happy");
            else
                System.out.println("Palavra não encontrada em nosso banco de dados.");

        }
    }
}
