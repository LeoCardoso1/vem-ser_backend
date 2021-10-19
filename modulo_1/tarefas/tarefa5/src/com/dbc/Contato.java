package com.dbc;

public class Contato {
    private final String descricao;
    private String telefone;
    private Integer tipo;

    Contato(String descricao, String telefone, Integer tipo) {
        this.descricao = descricao;
        this.telefone = telefone;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    void imprimirContato() {
        int tipo = getTipo();
        if(tipo == 1)
            System.out.println("Tipo Residencial");
        else
            System.out.println("Tipo Comercial");
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Telefone: " + getTelefone());
    }
}
