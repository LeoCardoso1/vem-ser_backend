package com.dbc;
public class Endereco {
    Integer tipo;
    String logadouro;
    Integer numeroEndereco;
    String complemento;
    String cep;
    String cidade;
    String estado;
    String pais;

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

    public void imprimirEndereco(){
        if (tipo == 1)
            System.out.println("Tipo: Residencial");
        else
            System.out.println("Tipo: Comercial");

        System.out.println("Logadouro: " + logadouro);
        System.out.println("Número: " + numeroEndereco);
        System.out.println("CEP: " + cep);
        System.out.println("Cidade: " + cidade);
        System.out.println("Estado: " + estado );
        System.out.println("País: " + pais);
        System.out.println("------------------");
    }


}
