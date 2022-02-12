/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aao_verfinal;

/**
 * Objetivo : Problema da mochila desenvolvido em Java Unidade Curricular :
 * Análise Algoritmica e Otimizacao Realizado por : Grupo 11 
 * 8150289 RUI DUARTE PEREIRA SOARES 
 * 8170464 FRANCISCO JOÃO MOREIRA VIEIRA 
 * 8170148 DIOGO GUILHERME CARVALHO DA SILVA 
 * Data: 24-05-2020
 */
public class Knapsack {

    /**
     * Funcao que devolve o item com maior valor que esteja dentro do limite Cap
     *
     * @param Cap Capcidade total da mochila
     * @param peso Peso de um certo item
     * @param valor Valor de um certo item
     * @param n_itens numero de itens totais a analisar
     */
    public static void knapSack(int Cap, int peso[], int valor[], int n_itens) {
        int TC = n_itens * Cap;
        int K[][] = new int[n_itens + 1][Cap + 1];
        int count = 0;
        int count2 =0;
        
        
    System.out.println("Tabela:");
        //constroi a tabela de baixo para cima
        for (int item = 1; item <= n_itens; item++) {
            //preencher a tabela linha a linha
            for (int weight = 1; weight <= Cap; weight++) {
                /*verifica se o item tem menos peso do que o peso que está a correr
                no cilco for acima*/
                
                if (peso[item-1]>weight)
                    count2++;                
                
                if ( peso[item-1] <= weight ) {
                    count2++;
                    /*compara o o melhor entre o valor para o mesmo peso sem o 
                    item e o item atual mais o valor do item na linha anterior*/
                    K[item][weight] = Math.max(K[item - 1][weight],K[item - 1][weight - peso[item - 1]] + valor[item - 1]);

                }
                /*se o peso do item é maior do que o peso "weight", passa a 
                frente com o valor sem o item atual*/
                else{
                    K[item][weight] = K[item - 1][weight];
                }
                //imprime cada item de linha
                System.out.format("%4d",K[item][weight]);
            count++;
            count2++;
            }
            //divisão das linhas da tabela
            System.out.println(" ");
            count2++;
        }
        
        
        System.out.println("_____________________________");
        System.out.println("Solução optima");
        int pesoPossivel =0;
        int valorPossivel =0;
        
        while (n_itens != 0) {
            
            if (K[n_itens][Cap] == K[n_itens - 1][Cap])
                count2++;            
            
            if (K[n_itens][Cap] != K[n_itens - 1][Cap]) {
                count2++;
                //guarda a soma de todos os pesos da solução optima
                pesoPossivel = pesoPossivel + peso[n_itens - 1];
                
                //guarda a soma de todos os valores da solução optima
                valorPossivel = valorPossivel + valor[n_itens - 1];
                
                //imprime a solução optima os pesos e valores dos respetivos itens
                System.out.println("Item " + n_itens + " valor = " + valor[n_itens - 1] + " peso = " + peso[n_itens - 1]);
                Cap = Cap - peso[n_itens - 1];
            }
            count2++;
            n_itens--;
        }
        System.out.println("_____________________________");
        System.out.println("Peso maximo da solução : " + pesoPossivel);
        System.out.println("Valor maximo da solução : " + valorPossivel);
        System.out.println("_____________________________");
        //Big O
        System.out.println("Big O(n_itens * Cap) : " + TC);
        //ciclos feitos para construir a tabela
        System.out.println("ciclos executados para construir a tabela : " + count);
        System.out.println("_____________________________");
        //runtme
        System.out.println("ciclos executados no total : " + count2);
        
    }

    /**
     * Funcao main com uma bateria de testes
     *
     * @param args
     */
    public static void main(String args[]) {
	//int peso[] = new int[]{4,6,5};
        //int peso[] = new int[]{4,6,5,8,2,1};
        int peso[] = new int[]{12, 2, 6, 4, 4, 2, 6, 7, 8, 3, 2, 4};
	
	
	//int valor[] = new int[]{2,3,5};
        //int valor[] = new int[]{2,3,5,5,3,2};
        int valor[] = new int[]{4, 2, 1, 2, 10, 5, 3, 4, 2, 1, 3, 2};
	
        //int Cap = 10;
        //int Cap = 15;
        int Cap = 35;
        
        int n_itens = valor.length;
        knapSack(Cap, peso, valor, n_itens);

    }
}
