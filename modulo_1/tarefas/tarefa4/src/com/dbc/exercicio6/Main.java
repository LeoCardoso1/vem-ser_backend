package com.dbc.exercicio6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("""
                Olá bem vindo ao nosso tradutor
                Escolha as opções a baixo:\s
                0-Português para Inglês
                1-Inglês para Poruguês""");

        int respostaUsuario = leia.nextInt();
        leia.nextLine();

        while (respostaUsuario < 0 || respostaUsuario > 1){
            System.out.println("Resposta inválida, digite novamente");
            respostaUsuario = leia.nextInt();
            leia.nextLine();
        }

        Tradutor traducao = new Tradutor(respostaUsuario);

        System.out.println("Digite a palavra que quer traduzir (ou sair para encerrar o programa):");
        String palavraUsuario = leia.nextLine();

        while (!palavraUsuario.equalsIgnoreCase("sair")){
            traducao.traduzir(palavraUsuario);
            System.out.println("Digite a palavra que quer traduzir (ou sair para encerrar o programa):");
            palavraUsuario = leia.nextLine();
        }

        System.out.println("Obrigado por usar o programa :D");


    }
}
