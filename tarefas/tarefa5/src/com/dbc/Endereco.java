package com.dbc;
public class Endereco {
    private Integer tipo;
    private String logadouro;
    private Integer numeroEndereco;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco(Integer tipo, String logadouro, Integer numeroEndereco, String complemento, String cep, String cidade,
             String estado, String pais){
        this.tipo = tipo;
        this.logadouro = logadouro;
        this.numeroEndereco = numeroEndereco;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public Integer getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(Integer numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void imprimirEndereco(){
        if (tipo == 1)
            System.out.println("Tipo: Residencial");
        else
            System.out.println("Tipo: Comercial");

        System.out.println("Logadouro: " + getLogadouro());
        System.out.println("Número: " + getNumeroEndereco());
        System.out.println("CEP: " + getCep());
        System.out.println("Cidade: " + getCidade());
        System.out.println("Estado: " + getEstado() );
        System.out.println("País: " + getPais());
        System.out.println("------------------");
    }


}
