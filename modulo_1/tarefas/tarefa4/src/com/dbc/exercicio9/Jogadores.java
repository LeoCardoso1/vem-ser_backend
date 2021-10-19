package com.dbc.exercicio9;

import java.util.Arrays;

public class Jogadores {
    int qtd;

    public Jogadores(int qtd) {
        this.qtd = qtd;
    }

    String[] nomes = new String[qtd];
    Double[][] jogadores = new Double[3][qtd];

    public int getQtd() {
        return qtd;
    }


    public int tamanhoNomes() {
        return nomes.length;
    }

    public void imprimirArray(){
        System.out.println(Arrays.toString(nomes));
        System.out.println(Arrays.deepToString(jogadores));
    }

    public void preencherArrayNomes(String nome, int i){
        nomes[i] = nome;
        System.out.println(nomes[i]);
    }

    public void preencherArrayNumeros(Double altura, Double idade, Double peso, int i){
        jogadores[0][i] = altura;
        jogadores[1][i] = idade;
        jogadores[2][i] = peso;
    }

    public void imprimeMaiorAltura(){
        double maiorAltura = 0;
        int indiceMaiorAltura = 0;
        for(int i = 0; i <= jogadores.length; i++){
            if (jogadores[0][i] > maiorAltura) {
                maiorAltura = jogadores[0][i];
                indiceMaiorAltura = i;
            }
        }
        System.out.println("Jogador com maior altura:" + nomes[indiceMaiorAltura] + " com " + maiorAltura );
    }

    public void imprimeMaiorPeso(){
        double maiorPeso = 0;
        int indiceMaiorPeso = 0;
        for(int i = 0; i <= jogadores.length; i++){
            if (jogadores[0][i] > maiorPeso) {
                maiorPeso = jogadores[0][i];
                indiceMaiorPeso = i;
            }
        }
        System.out.println("Jogador com maior altura:" + nomes[indiceMaiorPeso] + " com " + indiceMaiorPeso );
    }

    public void imprimeMaiorIdade(){
        double maiorIdade = 0;
        int indiceMaiorIdade= 0;
        for(int i = 0; i <= jogadores.length; i++){
            if (jogadores[0][i] > maiorIdade) {
                maiorIdade = jogadores[0][i];
                indiceMaiorIdade = i;
            }
        }
        System.out.println("Jogador com maior altura:" + nomes[indiceMaiorIdade] + " com " + maiorIdade );
    }

}
