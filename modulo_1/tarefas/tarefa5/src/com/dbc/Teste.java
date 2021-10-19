//package com.dbc;
//public class Teste {
//    public static void main(String[] args) {
//
//
//        Cliente c1, c2;
//        ContaCorrente cc1, cc2;
//
//        c1 = new Cliente("Madonna",
//                "1234567");
//        c1.enderecos[0] = new Endereco(
//                1,
//                "Isla Bonita",
//                400,
//                "304",
//                "912457",
//                "Lisboa",
//                "Lisboa",
//                "Portugal");
//        c1.contatos[0] = new Cliente.Contato("Fixo",
//                "34569712",
//                1);
//        cc1 = new ContaCorrente(
//                c1,
//                "1000",
//                5678,
//                300.0,
//                500.0);
//
//
//        c2 = new Cliente(
//                "Lady Gaga",
//                "7831234");
//        c2.enderecos[0] = new Endereco(1,
//                "Shallow Now",
//                450,
//                "205",
//                "20015",
//                "Malibu",
//                "Califórnia",
//                "Eua");
//        c2.contatos[0] = new Cliente.Contato("Celular",
//                "9813354",
//                2);
//        cc2 = new ContaCorrente(c2, "1001",
//                7856,
//                500.0,
//                500.0);
//
//
//        cc1.transferir(cc2, 250.0);
//
//        cc1.imprimirContaCorrente();
//        cc2.imprimirContaCorrente();
//    }
//}
