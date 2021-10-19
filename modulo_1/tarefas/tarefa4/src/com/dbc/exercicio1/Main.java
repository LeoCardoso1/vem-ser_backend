package com.dbc.exercicio1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Qual seu nome?");
        String nomeUsuario = leia.nextLine();

        System.out.println("Qual sua idade?");
        Integer idadeUsuario = leia.nextInt();
        leia.nextLine();

        System.out.println("Qual sua cidade?");
        String cidadeUsuario = leia.nextLine();

        System.out.println("Qual seu estado?");
        String estadoUsuario = leia.nextLine();

        Usuario usu1 = new Usuario(nomeUsuario, idadeUsuario, cidadeUsuario, estadoUsuario);

        usu1.imprimeDados();



    }
}
