package telas;

import java.util.Scanner;

import controladores.Creserva;
import java.util.Calendar;

public class Treserva {

    static Creserva controladorR = Creserva.getInstance();

    public static void Inicio() {
        int op = 1;
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        while (op != 0) {
            System.out.println("Digite (1) para criar uma nova reserva");
            System.out.println("Digite (2) para alterar uma reserva");
            System.out.println("Digite (3) para excluir uma reserva");
            System.out.println("Digite (4) para realizar check in");
            System.out.println("Digite (5) para realizar check out");
            System.out.println("Digite (0) para voltar");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    controladorR.criaR();
                    break;
                case 2:
                    controladorR.alteraR();
                    break;
                case 3:
                    controladorR.excluiR();
                    break;
                case 4:
                    controladorR.checkIn();
                    break;
                case 5:
                    controladorR.checkOut();
                    break;
                case 0:
                    break;
            }

        }
    }

    public static void criarReserva() {
        Scanner sc = new Scanner(System.in);
        int dia, mes, ano;
        Boolean cafe;
        System.out.println("Digite a data de entrada");
        System.out.println("Dia");
        dia = sc.nextInt();
        System.out.println("Mês");
        mes = sc.nextInt();
        System.out.println("Ano");
        ano = sc.nextInt();
        Calendar entrada = Calendar.getInstance();
        entrada.clear();
        entrada.set(ano, mes - 1, dia);
        System.out.println("Digite a data de saida ");
        System.out.println("Dia");
        dia = sc.nextInt();
        System.out.println("Mês");
        mes = sc.nextInt();
        System.out.println("Ano");
        ano = sc.nextInt();
        Calendar saida = Calendar.getInstance();
        saida.clear();
        saida.set(ano, mes - 1, dia);
        System.out.println("A reserva contem Cafe da manha?(s/n) " + entrada.compareTo(saida));
        cafe = sc.next().equalsIgnoreCase("s");
        System.out.println("Digite o numero do quarto");
        String nQuarto = sc.next();
        try {
            String id = controladorR.nReserva(entrada, saida, cafe, nQuarto);
            System.out.println("Reserva crida com id: " + id);
        } catch (Exception e) {
            System.out.println("Nao foi possivel realizar a reserva");
        }

    }

    public static void alteraReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o codigo da reserva");
        String idR = sc.next();
        int dia, mes, ano;
        Boolean cafe;
        System.out.println("Digite a data de entrada");
        System.out.println("Dia");
        dia = sc.nextInt();
        System.out.println("Mês");
        mes = sc.nextInt();
        System.out.println("Ano");
        ano = sc.nextInt();
        Calendar entrada = Calendar.getInstance();
        entrada.set(ano, mes, dia);
        System.out.println("Digite a data de saida");
        System.out.println("Dia");
        dia = sc.nextInt();
        System.out.println("Mês");
        mes = sc.nextInt();
        System.out.println("Ano");
        ano = sc.nextInt();
        Calendar saida = Calendar.getInstance();
        saida.set(ano, mes, dia);
        System.out.println("A reserva contem Cafe da manha?(s/n)");
        cafe = sc.next().equalsIgnoreCase("s");
        System.out.println("Digite o numero do quarto");
        String nQuarto = sc.next();
        controladorR.altReserva(idR, entrada, saida, cafe, nQuarto);
    }

    public static void excluirReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o codigo da reserva");
        String idR = sc.next();
        controladorR.excReserva(idR);
    }

    public static boolean confirmarPagamento(float pi) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Necessário pagamento de " + pi);
        System.out.println("Pagamento realizado? (s/n)");
        return sc.next().equalsIgnoreCase("s");
    }

    public static void PerguntaCheckIn() {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código da reserva que deseja fazer check in");
        String idR = sc.next();
        if(controladorR.ConfirmaCheckIn(idR)==0)
            System.out.println("Check in realizado");
        else
            System.out.println("Check in não realizado");
    }

    public static void PerguntaCheckOut() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o código da reserva que deseja fazer check out");
        String idR = sc.next();
        if(controladorR.ConfirmaCheckOut(idR)==0)
            System.out.println("Check out realizado");
        else
            System.out.println("Check out não realizado");
    }

}
