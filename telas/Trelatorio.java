/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import controladores.Crelatorio;
import java.util.Scanner;

/**
 *
 * @author bruno
 */
public class Trelatorio {

    static Crelatorio controladorR = Crelatorio.getInstance();

    public static void inicio() {
        int op = 1;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        while (op != 0) {
            System.out.println("Digite (1) para gerar relatório anual");
            System.out.println("Digite (2) para gerar relatório mensal");
            System.out.println("Digite (0) para sair");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    controladorR.relatorioAno();
                    break;
                case 2:
                    controladorR.relatorioMes();
                    break;
                case 0:
                    break;
            }

        }
    }

    public static void perguntaAno() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ano a ser consultado");
        int ano = sc.nextInt();
        System.out.println("Valor pendente  "+ controladorR.getRelatorioAnual(ano, Boolean.TRUE));
        System.out.println("Valor recebido  "+ controladorR.getRelatorioAnual(ano, Boolean.FALSE));

    }
    
    public static void perguntaMes() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o ano a ser consultado");
        int ano = sc.nextInt();
        System.out.println("Digite o mês a ser consultado");
        int mes = sc.nextInt();
        System.out.println("Valor pendente  "+ controladorR.getRelatorioMensal(mes, ano, Boolean.TRUE));
        System.out.println("Valor recebido  "+ controladorR.getRelatorioMensal(mes, ano, Boolean.FALSE));

    }

}
