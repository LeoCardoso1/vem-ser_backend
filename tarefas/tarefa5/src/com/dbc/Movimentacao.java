package com.dbc;

public interface Movimentacao{

    Boolean sacar(double valor);
    Boolean depositar(double valor);
    Boolean transferir(Conta contaDestino, double valor);
}
