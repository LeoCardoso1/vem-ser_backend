package com.dbc;

public class Conta implements Movimentacao {

    private Cliente cliente;
    private String numeroConta;
    private Integer agencia;
    private Double saldo;


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public Boolean sacar(double valor) {
        if (valor < 0) {
            System.out.println("Não é permitido sacar valores negativos");
            return false;
        } else {
            saldo -= valor;
            System.out.println("Operação saque feita com sucesso!");
            return true;
        }
    }

    @Override
    public Boolean depositar(double valor) {
        if (valor < 0) {
            System.out.println("Não é permitido depositar valores negativos");
            return false;
        } else {
            saldo += valor;
            System.out.println("Operação depósito feita com sucesso!");
            return true;
        }
    }

    @Override
    public Boolean transferir(Conta contaDestino, double valor) {
        if (valor < 0) {
            System.out.println("Não é permitido transferir valores negativos. ");
            return false;
        }else{
            saldo -= valor;
            double total = contaDestino.getSaldo() + valor;
            contaDestino.setSaldo(total);
            System.out.println("Operação transferência feita com sucesso. ");
            return true;
        }
    }
}
