package com.dbc;

public class Cliente {
    String nome;
    String cpf;
    Contato[] contatos = new Contato[2];
    Endereco[] enderecos = new Endereco[2];

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public static class Contato {
        String descricao;
        String telefone;
        Integer tipo;

        Contato(String descricao, String telefone, Integer tipo){
            this.descricao = descricao;
            this.telefone = telefone;
            this.tipo = tipo;
        }

        void imprimirContato(){
            System.out.println("Descrição: " + descricao);
            System.out.println("Telefone: " + telefone);
            System.out.println("Tipo: " + tipo);
        }
    }
}
