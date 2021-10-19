package com.dbc;

public class Cliente {
    private String nome;
    private final String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(Contato[] contatos) {
        this.contatos = contatos;
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Endereco[] enderecoSetado) {
        this.enderecos = enderecoSetado;
    }

    public void imprimirContatos() {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos.length == 1) {
                contatos[0].imprimirContato();
                break;
            } else
                contatos[i].imprimirContato();
        }
    }

    public void imprimirEnderecos() {
        for (int i = 0; i < enderecos.length; i++) {
            if (enderecos.length == 1) {
                enderecos[0].imprimirEndereco();
                break;
            } else
                enderecos[i].imprimirEndereco();
        }
    }

    public void imprimirCliente(){
        System.out.println("Nome Cliente: " + getNome() + "\nCpf: " + getCpf() + "\n------------------");
    }
}

