package com.dbc.exercicio4;

public class Cidades {
    String [][] cidadesString = {{"PR", "Curitiba"}, {"PR", "Pato Branco"}, {"SC", "Florianópils"},
            {"SC", "Chapecó"}, {"RS", "Porto Alegre"},  {"RS", "Canoas"}};


    Double [][] cidadesDouble = {{1.9, 0.823, 18.0},{0.085, 0.872, 18.2},{0.5, 0.847, 20.8},{0.224, 0.790, 19.0},
            {1.4, 0.805, 19.7}, {0.348, 0.705, 19.6}};

    int estado;
    int cidade;
    int escolha;

    public Cidades(int estado, int cidade, int escolha) {
        this.estado = estado;
        this.cidade = cidade;
        this.escolha = escolha;
    }

    public String determinaCidade(){
        if(estado == 0)
            if(cidade == 0)
                return "Curitiba";
            else
                return "Pato Branco";
        else if(estado == 1)
            if(cidade == 0)
                return "Florianópolis";
            else
                return "Chapecó";
        else
            if(cidade == 0)
                return "Porto Alegre";
            else
                return "Canoas";
    }

    public void imprimeDados(){
        String nomeCidade = determinaCidade();
        int iI = 0;                         // Indice de impresão

        for(int i = 0; i < cidadesString.length; i++){
            if(nomeCidade.equals(cidadesString[i][1])) {
                iI = i;
                break;
            }
        }

        if (escolha == 0)
            System.out.println(nomeCidade + " tem aproximadamente " + cidadesDouble[iI][0] + " milhão de habitantes");
        else if(escolha == 1)
            System.out.println(nomeCidade + " tem IDH(2010) de " + cidadesDouble[iI][1]);
        else
            System.out.println(nomeCidade + " tem média anual de " + cidadesDouble[iI][2] + "ºC");
    }


}
