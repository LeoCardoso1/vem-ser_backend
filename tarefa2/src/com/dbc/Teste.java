package com.dbc;

public class Teste {
    public static void main(String[] args) {
        int [] exemplo = {0, 2, 3, 4, 8};

        for (int i = 0; i < exemplo.length; i++){
            exemplo[i] = i;
        }

        for (int i = 0; i < exemplo.length; i++){
            System.out.println(i);
        }
    }
}
