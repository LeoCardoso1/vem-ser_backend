package com.dbc.exercicio7;

public class ListaPapelaria {
    String nome;
    Double valor;
    Double desconto = 0.05;

    public ListaPapelaria(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void listar(){
        System.out.println("Nome do produto:" + getNome());
        System.out.println("Valor: " + getValor());
        System.out.println("-----------------------------");
        for(int i = 1; i <= 10; i++){
            double valorComDesconto = valor - (valor * i * desconto);
            System.out.printf("%d x %.1f = %.2f", i, valorComDesconto, (i * valorComDesconto));
            System.out.println();
        }
    }
}
