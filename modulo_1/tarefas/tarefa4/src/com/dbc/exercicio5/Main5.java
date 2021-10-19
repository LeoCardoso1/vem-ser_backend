package com.dbc.exercicio5;
import java.util.Scanner;

public class Main5 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);

        System.out.println("Qual o valor da hora trabalhada?");
        Double horaTrabalhada = leia.nextDouble();
        leia.nextLine();

        System.out.println("Quantas horas foram trabalhadas?");
        Integer numeroHorasFuncionario = leia.nextInt();
        leia.nextLine();

        System.out.println("Digite as horas extras: ");
        Integer numeroHorasExtras = leia.nextInt();
        leia.nextLine();

        System.out.println("Digite as horas extras noturnas: ");
        Integer numeroHorasExtrasNoturnas = leia.nextInt();
        leia.nextLine();

        Salario salarioFuncionario = new Salario(horaTrabalhada, numeroHorasFuncionario, numeroHorasExtras,
                numeroHorasExtrasNoturnas);

        salarioFuncionario.salarioTotal();
    }
}
