package com.dbc;

public class ContaCorrente extends Conta implements Impressao {
    Double chequeEspecial;


    public Double retornarSaldoComChequeEspecial() {
        return super.getSaldo() + chequeEspecial;
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public Double getChequeEspecial(){
        return chequeEspecial;
    }

    public Boolean sacar(Double valor) {
        double valorSaldo = super.getSaldo();

        if (valor <= 0) {
            System.out.println("Você não pode sacar um valor negativo ou zero.");
            return false;
        } else if (valor > (super.getSaldo() + chequeEspecial)) {
            System.out.println("Valor supera o saldo e o limite do cheque especial");
            return false;
        } else {
            if(valor <= valorSaldo){
            valorSaldo -= valor;
            super.setSaldo(valorSaldo);
            System.out.println("Operação saque feita com sucesso!");
            }else{
                valor = valor - getSaldo();
                Double novoValorChequeEspecial = getChequeEspecial() - valor;
                setChequeEspecial(novoValorChequeEspecial);
                System.out.println("Operação saque feita com sucesso!\nOperação usou saldo do cheque especial\nSaldo atual" +
                        "do cheque especial: R$" + getChequeEspecial());
            }
            return true;
        }
    }

    @Override
    public void imprimir() {
        System.out.println("Conta Corrente\nNome do cliente: " + (super.getCliente()).getNome() + "\nConta: "
                + super.getNumeroConta() + "\nAgência:" + super.getAgencia() + "\nLimite do cheque especial: R$" +
                getChequeEspecial() + "\n------------------");
    }
}
