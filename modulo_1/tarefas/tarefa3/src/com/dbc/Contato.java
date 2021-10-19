package com.dbc;

public class Contato {
    String descricao;
    String telefone;
    Integer tipo;

    Contato(String descricao, String telefone, Integer tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    void imprimirContato() {
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Tipo: " + this.tipo);
    }
}
