package com.dbc.exercicio14;

public class Alunos {
    double[][] alunos = new double[][]{{300.0D, 8.0D, 7.0D, 0.0D}, {301.0D, 9.0D, 8.0D, 0.0D},
            {302.0D, 6.0D, 6.0D, 0.0D}, {303.0D, 7.5D, 7.8D, 0.0D}, {304.0D, 8.0D, 7.5D, 0.0D}};

    public void imprimeDados() {
        for (int i = 0; i < alunos.length; ++i) {
            System.out.println(i + 1 + "º aluno: ");
            System.out.println("Número de matrícula: " + alunos[i][0]);
            System.out.println("Média das provas: " + alunos[i][1]);
            System.out.println("Média dos trabalhos: " + alunos[i][2]);
            System.out.println("--------------------------");

        }
    }

    public void calcularMediaFinal() {
        for (int i = 0; i < alunos.length; ++i) {
            double notaFinal = alunos[i][1] * 0.6D + alunos[i][2] * 0.4D;
            alunos[i][3] = notaFinal;
        }
    }

    public void imprimeMatriculaComMaiorMediaFinal(){
        double maiorNota = 0.0;
        double matriculaComMaiorNotaFinal = 0.0;

        for (double[] aluno : alunos) {
            if (aluno[3] > maiorNota) {
                matriculaComMaiorNotaFinal = aluno[0];
            }
        }
        System.out.println("Matrícula com maior nota final: " + (int)matriculaComMaiorNotaFinal);
    }

    public void cacularMediaDasNotasFinais(){
        double totalNotas = 0.0D;

        for(int i = 0; i < alunos.length; ++i) {
            totalNotas += alunos[i][2];
        }

        double mediaNotas = totalNotas / (double)alunos.length;
        System.out.println("Média das notas finais: " + mediaNotas);

    }


}
