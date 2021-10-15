package com.dbc;

public class Main {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente("Dawn", "0150101236");
        ContaPagamento contapagamento1 = new ContaPagamento();
        contapagamento1.setCliente(cliente1);
        contapagamento1.setSaldo(500.0);
        contapagamento1.setNumeroConta("203-5");
        contapagamento1.setAgencia(205);

        ContaCorrente contacorrente1 = new ContaCorrente();
        contacorrente1.setCliente(cliente1);
        contacorrente1.setSaldo(200.0);
        contacorrente1.setNumeroConta("303-5");
        contacorrente1.setAgencia(205);
        contacorrente1.setChequeEspecial(500.0);

        Cliente cliente2 = new Cliente("Misty", "0144569213");
        ContaPoupanca contapoupanca1 = new ContaPoupanca();
        contapoupanca1.setCliente(cliente2);
        contapoupanca1.setSaldo(1000.0);
        contapoupanca1.setNumeroConta("308-5");
        contapoupanca1.setAgencia(304);


        contapagamento1.sacar(10.0);
        contapoupanca1.transferir(contacorrente1, 200.0);
        contacorrente1.depositar(100.0);

        System.out.println("------------------");
        contapagamento1.imprimir();
        contacorrente1.imprimir();
        contapoupanca1.imprimir();

        System.out.println(contacorrente1.getSaldo());
        System.out.println(contacorrente1.getChequeEspecial());
        contacorrente1.sacar(-10.0);





    }
}
