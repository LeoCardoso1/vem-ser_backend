package com.dbc.exercicio10;

public class MenorDigitado {

    public void retornarOMenor(Integer [] lista){
        Integer menor = 100000;
        for (Integer numero: lista){
            if(numero < menor)
                menor = numero;
        }
        System.out.println("O menor número é: " + menor);
    }
}
