package telas;

import java.util.Scanner;

import controladores.Cprincipal;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Item;
import subItens.Tv;

public class Tprincipal {

    static Cprincipal controlador = Cprincipal.getInstance();


    public static void main(String args[]) {
        @SuppressWarnings("resource")
        int op = 1;
        Scanner sc = new Scanner(System.in);
        while (op != 0) {
            System.out.println("Digite (1) para Gerenciar as reservas");
            System.out.println("Digite (2) para Gerenciar quartos");
            System.out.println("Digite (3) para Gerenciar hotel");
            System.out.println("Digite (4) para gerar relatorios");
            System.out.println("Digite (0) para sair");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    controlador.gReserva();
                    break;
                case 2:
                    controlador.gQuartos();
                    break;
                case 3:
                    controlador.gHotel();
                    break;
                case 4:
                    controlador.gRelatorios();
                    break;
                case 0:
                    System.out.println("Programa encerrado!");
                    break;
            }

        }
    }
}
