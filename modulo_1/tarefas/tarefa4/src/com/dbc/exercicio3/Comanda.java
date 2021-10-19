package com.dbc.exercicio3;



public class Comanda {
//    static Integer numeroComanda = 0;
    Double totalComanda;
    Double dinheiroPago;

    public Comanda(Double totalComanda, Double dinheiroPago) {
//        numeroComanda += 1;
        this.totalComanda = totalComanda;
        this.dinheiroPago = dinheiroPago;
    }

    public Double getTotalComanda() {
        return totalComanda;
    }

    public Double getDinheiroPago() {
        return dinheiroPago;
    }

    Double calculaTroco(){
        return dinheiroPago - totalComanda;
    }

    void imprimeDados(){
//        System.out.println("Número da comanda: " + numeroComanda);
        System.out.println("Total da comanda: R$ " + getTotalComanda());
        System.out.println("Dinheiro pago: R$ " + getDinheiroPago());
        System.out.println("Troco: R$ " + calculaTroco());
    }
}
