package com.dbc.exercicio5;

public class Salario {
    Double valorHora;
    Integer horasNormais;
    Integer horasExtras;
    Integer horasExtrasNoturnas;

    public Salario(Double valorHora,Integer horasNormais, Integer horasExtras, Integer horasExtrasNoturnas) {
        this.valorHora = valorHora;
        this.horasNormais = horasNormais;
        this.horasExtras = horasExtras;
        this.horasExtrasNoturnas = horasExtrasNoturnas;
    }

    public void salarioTotal(){
        System.out.println("O salário total do funcionário é: R$ " + ((horasNormais * valorHora) +
                (horasExtras * valorHora * 1.5)
                + (horasExtrasNoturnas * valorHora * 2)));

    }


}
