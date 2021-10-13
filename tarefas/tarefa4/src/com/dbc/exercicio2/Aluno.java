package com.dbc.exercicio2;

public class Aluno {
    String nome;
    Double [] notas = new Double[4];


    public Aluno(String nome, Double[] notas) {
        this.nome = nome;
        this.notas = notas;
    }

    public String getNome() {
        return nome;
    }

    public Double retornaMedia(){
        Double soma = 0.0;
        for(int i = 0; i < 4; i++){
            soma += notas[i];
        }
        return (soma / 4);
    }

    public String retronaAvaliacao(){
        Double media = retornaMedia();
        if (media < 5)
            return "Reprovado";
        else if(media > 5 && media < 7)
            return "Em exame";
        else
            return "Aprovado";
    }

    public void imprimeDados(){
        System.out.println("Nome: " + getNome());
        System.out.println("Média: %.2f " + retornaMedia());
        System.out.println("Resultado: " + retronaAvaliacao());
    }
}


