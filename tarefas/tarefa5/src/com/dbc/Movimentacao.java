package com.dbc;

public interface Movimentacao{

    Boolean sacar(Double valor);
    Boolean depositar(Double valor);
    Boolean transferir(Conta contaDestino, Double valor);
}
