package com.dbc.exercicio13;

public class Matriz {
    double [][] matriz = new double[4][4];

    void preenchendoMatriz(int i, int j, double valor){
        matriz[i][j] = valor;
    }



    void conferindoMaioresQueDez(){
        int cont = 0;
        System.out.println("Listagem dos números maiores que 10 na matriz: ");
        for (int i = 0; i <= 3; i++){
            for(int j = 0; j <= 3; j++){
                if(matriz[i][j] >= 10) {
                    System.out.println(matriz[i][j]);
                    cont++;
                }
            }
        }
        System.out.println("Quantidade: " +cont);
    }

}
