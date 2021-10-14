package com.dbc;

import java.util.Arrays;

public class Teste2 {
    public static void main(String[] args) {

        Cliente cliente1;
        cliente1 = new Cliente("Jubileu", "0257891023");
        cliente1.getContatos()[0] = new Contato("whats","98531012",1);
        cliente1.getEnderecos()[0] = new Endereco(1,"Rua Maricás", 660, "casa",
                "92200660", "Canoas", "RS", "Brasil");

        Contato contatoteste = cliente1.getContatos()[0];
        Endereco enderecoteste = cliente1.getEnderecos()[0];

        cliente1.imprimirCliente();
        enderecoteste.imprimirEndereco();



    }
}
