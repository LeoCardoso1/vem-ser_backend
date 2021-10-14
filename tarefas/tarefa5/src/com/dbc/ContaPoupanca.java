package com.dbc;

public class ContaPoupanca extends Conta implements Impressao{
    private final static Double TAXA_MENSAL = 1.01;

    @Override
    public void imprimir() {
        System.out.println("Nome do cliente: " + (super.getCliente()).getNome() + "\nConta: " + super.getNumeroConta() + "\nAgência:" +
                "" + super.getAgencia() + "\nTaxa mensal de juros: " + TAXA_MENSAL + "%");

    }

    public void creditarTaxa(){
        Double novoSaldo = super.getSaldo() * TAXA_MENSAL;
        setSaldo(novoSaldo);
    }


}
