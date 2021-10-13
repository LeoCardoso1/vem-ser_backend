package com.dbc.exercicio1;

public class Usuario {
    String nome;
    Integer anos;
    String cidade;
    String estado;

    public Usuario(String nome, Integer anos, String cidade, String estado) {
        this.nome = nome;
        this.anos = anos;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public Integer getAnos() {
        return anos;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void imprimeDados(){
        System.out.println("O seu nome é: " + getNome() + ", você tem " + getAnos() + " anos, é da cidade de " +
                getCidade() + ", situada no estado de " + getEstado() + ".");

    }
}
