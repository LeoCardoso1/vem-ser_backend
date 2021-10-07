package com.dbc;

import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Qual a sigla do estado? \n1-Paraná \n2-Santa Catarina \n3-Rio Grande do Sul");
        int resposta = leia.nextInt();
        leia.nextLine();

        while (resposta < 1 || resposta > 3) {
            System.out.println("Resposta inválida, digite novamente");
            resposta = leia.nextInt();
            leia.nextLine();
        }

        if (resposta == 1) {
            System.out.println("Escolha uma das duas cidades: \n1-Curtiba\n2-Pato Branco");
            int cidade = leia.nextInt();
            while (cidade < 1 || cidade > 2) {
                System.out.println("Resposta inválida, digite novamente");
                cidade = leia.nextInt();
                leia.nextLine();
            }
            if (cidade == 1) {
                System.out.println("O que deseja saber sobre Curitiba?\n1-População\n2-IDH\n3-Temperatura média");
                int dado = leia.nextInt();
                while (dado < 1 || dado > 3) {
                    System.out.println("Resposta inválida, digite novamente");
                    dado = leia.nextInt();
                    leia.nextLine();
                }
                if (dado == 1)
                    System.out.println("Curitiba tem aproximadamente 1,9 milhão habitantes");
                else if (dado == 2)
                    System.out.println("Curitiba tem IDH de 0,823(2010)");
                else
                    System.out.println("A temperatura média anual de Curtiba é 18ºC");
            } else {
                System.out.println("O que deseja saber sobre Pato Branco?\n1-População\n2-IDH\n3-Temperatura média");
                int dado = leia.nextInt();
                while (dado < 1 || dado > 3) {
                    System.out.println("Resposta inválida, digite novamente");
                    dado = leia.nextInt();
                    leia.nextLine();
                }
                if (dado == 1)
                    System.out.println("Pato Branco tem aproximadamente 85 mil habitantes");
                else if (dado == 2)
                    System.out.println("Pato Branco tem IDH de 0,782(2010)");
                else
                    System.out.println("A temperatura média anual de Pato Branco é 18,5ºC");
            }

        }else if (resposta == 2) {
            System.out.println("Escolha uma das duas cidades: \n1-Florianópolis\n2-Chapecó");
            int cidade = leia.nextInt();
            while (cidade < 1 || cidade > 2) {
                System.out.println("Resposta inválida, digite novamente");
                cidade = leia.nextInt();
                leia.nextLine();
            }
            if (cidade == 1) {
                System.out.println("O que deseja saber sobre Florianópolis?\n1-População\n2-IDH\n3-Temperatura média");
                int dado = leia.nextInt();
                while (dado < 1 || dado > 3) {
                    System.out.println("Resposta inválida, digite novamente");
                    dado = leia.nextInt();
                    leia.nextLine();
                }
                if (dado == 1)
                    System.out.println("Florianópolis tem aproximadamente 508 mil habitantes");
                else if (dado == 2)
                    System.out.println("Florianópolis tem IDH de 0,847(2010)");
                else
                    System.out.println("A temperatura média anual de Florianópolis é 20,8ºC");
            } else {
                System.out.println("O que deseja saber sobre Chapecó?\n1-População\n2-IDH\n3-Temperatura média");
                int dado = leia.nextInt();
                while (dado < 1 || dado > 3) {
                    System.out.println("Resposta inválida, digite novamente");
                    dado = leia.nextInt();
                    leia.nextLine();
                }
                if (dado == 1)
                    System.out.println("Chapecó tem aproximadamente 224 mil habitantes");
                else if (dado == 2)
                    System.out.println("Chapecó tem IDH de 0,790(2010)");
                else
                    System.out.println("A temperatura média anual de Chapecó é 19ºC");
            }

        }else{System.out.println("Escolha uma das duas cidades: \n1-Porto Alegre\n2-Canoas");
            int cidade = leia.nextInt();
            while (cidade < 1 || cidade > 2) {
                System.out.println("Resposta inválida, digite novamente");
                cidade = leia.nextInt();
                leia.nextLine();
            }
            if (cidade == 1) {
                System.out.println("O que deseja saber sobre Porto Alegre?\n1-População\n2-IDH\n3-Temperatura média");
                int dado = leia.nextInt();
                while (dado < 1 || dado > 3) {
                    System.out.println("Resposta inválida, digite novamente");
                    dado = leia.nextInt();
                    leia.nextLine();
                }
                if (dado == 1)
                    System.out.println("Porto Alegre tem aproximadamente 1,4 milhão habitantes");
                else if (dado == 2)
                    System.out.println("Porto Alegre tem IDH de 0,805(2010)");
                else
                    System.out.println("A temperatura média anual de Porto Alegre é 19,7ºC");
            } else {
                System.out.println("O que deseja saber sobre Canoas?\n1-População\n2-IDH\n3-Temperatura média");
                int dado = leia.nextInt();
                while (dado < 1 || dado > 3) {
                    System.out.println("Resposta inválida, digite novamente");
                    dado = leia.nextInt();
                    leia.nextLine();
                }
                if (dado == 1)
                    System.out.println("Canoas tem aproximadamente 348 mil habitantes");
                else if (dado == 2)
                    System.out.println("Canoas tem IDH de 0,705(2010)");
                else
                    System.out.println("A temperatura média anual de Canoas é 19,6ºC");
            }

        }
    }
}
