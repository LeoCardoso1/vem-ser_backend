package com.dbc;

public class ContaPagamento extends Conta implements Impressao {
    private final static Double TAXA_SAQUE = 4.25;

    @Override
    public void imprimir() {
        System.out.println("Conta Pagamento\nNome do cliente: " + (super.getCliente()).getNome() + "\nConta: "
                + super.getNumeroConta() + "\nAgência:" + super.getAgencia() + "\nTaxa de saque: R$ " + TAXA_SAQUE
                + "\n------------------");


    }

    @Override
    public Boolean sacar(double valor) {
        double saldoDaConta = super.getSaldo();
        double valorComTaxa = valor + TAXA_SAQUE;

        if(saldoDaConta < valorComTaxa) {
            System.out.println("Não foi possível concluir a operação");
            valorComTaxa = 0;
        }
        return super.sacar(valorComTaxa);
    }


}

