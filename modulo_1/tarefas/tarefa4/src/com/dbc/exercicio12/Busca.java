package com.dbc.exercicio12;

public class Busca {
    int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public void imprimeSeContemNumero(int numeroUsuario) {
        boolean resposta = false;
        for (int numero : numeros){
            if (numero == numeroUsuario) {
                resposta = true;
                break;
            }
        }
        imprime(resposta);
    }

    public void imprime(boolean resposta){
        if (resposta)
            System.out.println("Número encontrado.");
        else
            System.out.println("Número não encontrado.");
    }
}
