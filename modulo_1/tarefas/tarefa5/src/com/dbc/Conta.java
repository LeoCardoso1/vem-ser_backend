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
    public Boolean sacar(Double valor) {
        if (valor < 0) {
            System.out.println("Não é permitido sacar valores negativos");
            return false;
        } else {
            if (valor > saldo) {
                System.out.println("Saque maior que o saldo");
                return false;
            } else {
                saldo -= valor;
                System.out.println("Operação saque feita com sucesso!");
                return true;
            }
        }
    }

    @Override
    public Boolean depositar(Double valor) {
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
    public Boolean transferir(Conta contaDestino, Double valor) {
        if (valor < 0) {
            System.out.println("Não é permitido transferir valores negativos. ");
            return false;
        }else {
            if (valor > saldo) {
                System.out.println("Valor maior que o saldo da conta");
                return false;
            } else {
                saldo -= valor;
                Double total = contaDestino.getSaldo() + valor;
                contaDestino.setSaldo(total);
                System.out.println("Operação transferência feita com sucesso. ");
                return true;
            }
        }
    }
}
