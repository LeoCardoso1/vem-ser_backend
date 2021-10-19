package com.dbc.exercicio9;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Quantos jogadores serão listados?");
        int qtd = leia.nextInt();
        leia.nextLine();

        Jogadores listaJogadores = new Jogadores(qtd);


        System.out.println(listaJogadores.getQtd());
        System.out.println(listaJogadores.tamanhoNomes());


//        listaJogadores.imprimirArray();
//
//        int indice = 0;
//
//        String nome;
//        double altura;
//        double idade;
//        double peso;
//
//        for(int i = 0; i <= qtd; i++){
//            System.out.println("Nome do " + (i + 1) + "º jogador");
//            nome = leia.nextLine();
//
//
//            System.out.println("Altura do " + (i + 1) + "º jogador");
//            altura = leia.nextDouble();
//            leia.nextLine();
//
//            System.out.println("Idade do " + (i + 1) + "º jogador");
//            idade = leia.nextDouble();
//            leia.nextLine();
//
//            System.out.println("Peso do " + (i + 1) + "º jogador");
//            peso = leia.nextDouble();
//            leia.nextLine();
//
//            listaJogadores.preencherArrayNomes(nome, indice);
//            listaJogadores.preencherArrayNumeros(altura, idade, peso, indice);
//
//            indice += 1;
//        }
//
//        listaJogadores.imprimeMaiorAltura();
//        listaJogadores.imprimeMaiorIdade();
//        listaJogadores.imprimeMaiorPeso();

    }
}
