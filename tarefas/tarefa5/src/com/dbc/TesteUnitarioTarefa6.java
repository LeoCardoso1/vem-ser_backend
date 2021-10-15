package com.dbc;

import org.junit.Test;

import static org.junit.Assert.*;

public class TesteUnitarioTarefa6 {

    @Test
    public void deveTestarSaqueContaCorrenteEVerificarSaldoComSucesso(){

        ContaCorrente contaCorrenteMisty = new ContaCorrente();
        contaCorrenteMisty.setSaldo(1500.0);
        contaCorrenteMisty.setChequeEspecial(500.0);

        boolean sacar = contaCorrenteMisty.sacar(200.0);
        Double saldo = contaCorrenteMisty.getSaldo();

        assertTrue(sacar);
        assertEquals(1300.0, saldo, 0);
    }

    @Test
    public void deveTestarSaqueContaCorrenteSemSaldo(){
        ContaCorrente contaCorrenteMisty = new ContaCorrente();
        contaCorrenteMisty.setSaldo(1000.0);
        contaCorrenteMisty.setChequeEspecial(1000.0);

        boolean sacar = contaCorrenteMisty.sacar(500.0);
        Double saldo = contaCorrenteMisty.getSaldo();

        assertTrue(sacar);
        assertEquals(500, saldo, 0);
    }

    @Test
    public void deveTestarSaqueContaPoupancaEVerificarSaldoComSucesso(){
        ContaPoupanca contaPoupancaMisty = new ContaPoupanca();
        contaPoupancaMisty.setSaldo(2000.0);
        contaPoupancaMisty.creditarTaxa();

        Double contaCreditada = contaPoupancaMisty.getSaldo();

        assertEquals(2020.0, contaCreditada, 0);

    }

    @Test
    public void deveTestarSaqueContaPoupancaSemSaldo(){
        ContaPoupanca contaPoupancaMisty = new ContaPoupanca();
        contaPoupancaMisty.setSaldo(2000.0);

        boolean sacar = contaPoupancaMisty.sacar(5000.0);

        assertFalse(sacar);
    }

    @Test
    public void deveTestarSaqueContaPagamentoEVerificarSaldoComSucesso(){
        ContaPagamento contaPagamentoMisty = new ContaPagamento();
        contaPagamentoMisty.setSaldo(2000.0);

        boolean sacar = contaPagamentoMisty.sacar(100.0);
        Double saldo = contaPagamentoMisty.getSaldo();

        assertTrue(sacar);
        assertEquals(1895.75, saldo, 1);
    }

    @Test
    public void deveTestarSaqueContaPagamentoSemSaldo(){
        ContaPagamento contaPagamentoMisty = new ContaPagamento();
        contaPagamentoMisty.setSaldo(2000.0);

        boolean sacar = contaPagamentoMisty.sacar(3000.0);

        assertTrue(sacar);
    }

    @Test
    public void deveTestarTransferenciaEVerificarSaldoComSucesso(){
        ContaCorrente contaCorrenteMisty = new ContaCorrente();
        contaCorrenteMisty.setSaldo(1000.0);
        contaCorrenteMisty.setChequeEspecial(1000.0);

        ContaCorrente contaCorrenteDawn = new ContaCorrente();
        contaCorrenteDawn.setSaldo(2000.0);
        contaCorrenteDawn.setChequeEspecial(500.0);

        boolean transferencia = contaCorrenteMisty.transferir(contaCorrenteDawn, 200.0);
        Double saldoMisty = contaCorrenteMisty.getSaldo();
        Double saldoDawn = contaCorrenteDawn.getSaldo();

        assertTrue(transferencia);
        assertEquals(800, saldoMisty, 1);
        assertEquals(2200, saldoDawn, 1);
    }

    @Test
    public void deveTestarTransferenciaSemSaldo(){
        ContaCorrente contaCorrenteMisty = new ContaCorrente();
        contaCorrenteMisty.setSaldo(1000.0);
        contaCorrenteMisty.setChequeEspecial(1000.0);

        ContaCorrente contaCorrenteDawn = new ContaCorrente();
        contaCorrenteDawn.setSaldo(2000.0);
        contaCorrenteDawn.setChequeEspecial(500.0);

        boolean transferencia = contaCorrenteMisty.transferir(contaCorrenteDawn, 5200.0);

        assertFalse(transferencia);
    }

    @Test
    public void deveTestarDepositoEVerificarSaldoComSucesso(){
        ContaCorrente contaCorrenteMisty = new ContaCorrente();
        contaCorrenteMisty.setSaldo(1000.0);
        contaCorrenteMisty.setChequeEspecial(1000.0);

        boolean deposito = contaCorrenteMisty.depositar(500.0);
        Double saldo = contaCorrenteMisty.getSaldo();

        assertTrue(deposito);
        assertEquals(1500.0, saldo, 1);
    }

    @Test
    public void deveTestarDepositoNegativo(){
        ContaCorrente contaCorrenteMisty = new ContaCorrente();
        contaCorrenteMisty.setSaldo(1000.0);
        contaCorrenteMisty.setChequeEspecial(1000.0);

        boolean deposito = contaCorrenteMisty.depositar(-5000.0);

        assertFalse(deposito);
    }





}
