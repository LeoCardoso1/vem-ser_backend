package com.dbc.exercicio4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("""
                Digite a opção de estado?\s
                0-Paraná\s
                1-Santa Catarina\s
                2-Rio Grande do Sul""");
        int numeroEstado = leia.nextInt();
        leia.nextLine();

        while(numeroEstado < 0 || numeroEstado > 2){
            System.out.println("Digite uma opção válida");
            numeroEstado = leia.nextInt();
            leia.nextLine();
        }


        if(numeroEstado == 0) {
            System.out.println("Escolha a cidade do PR\n0- Curtiba\n1- Pato Branco");
        }
        else if(numeroEstado == 1) {
            System.out.println("Escolha a cidade do SC\n0- Florianópolis\n1- Chapecó");
        }else{
            System.out.println("Escolha a cidade do RS\n0- Porto Alegre\n1- Canoas");
        }

        int numeroCidade = leia.nextInt();
        leia.nextLine();

        while(numeroCidade < 0 || numeroCidade > 2){
            System.out.println("Digite uma opção válida");
            numeroCidade = leia.nextInt();
            leia.nextLine();
        }

        System.out.println("""
                O que deseja saber sobre a cidade? Digite a opção\s
                0- Quantidade de habitantes
                1- IDH
                2- Temperatura média anual""");

        int escolhaInformacao = leia.nextInt();
        leia.nextLine();

        while(escolhaInformacao < 0 || escolhaInformacao > 3){
            System.out.println("Digite uma opção válida");
            escolhaInformacao = leia.nextInt();
            leia.nextLine();
        }

        Cidades pesquisaCidades = new Cidades(numeroEstado, numeroCidade, escolhaInformacao);

        pesquisaCidades.imprimeDados();








    }
}
