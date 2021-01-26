package telas;
import java.util.Scanner;

import controladores.Chotel;
public class Thotel {
	static Chotel controladorT = Chotel.getInstance();
	public static void Inicio() {
		int op=1;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (op != 0) {
			System.out.println("Digite (1) para alterar pre�o base da reserva");
			System.out.println("Digite (2) para alterar pre�o base do caf�");
			System.out.println("Digite (0) para sair");
			op = sc.nextInt();
			switch (op) {
			case 1:
				controladorT.precoBaseReserva();
				break;
			case 2:
				controladorT.precoBaseCafe();
				break;
			case 0:
				break;
			}

		}
	}
	public static void precoReserva() {
		System.out.println("Digite o novo valor da reserva");
		Scanner sc = new Scanner(System.in);
		float preco = sc.nextFloat();
		controladorT.nPrecoReserva(preco);
	}
	public static void precoCafe() {
		System.out.println("Digite o novo valor da reserva");
		Scanner sc = new Scanner(System.in);
		float o = sc.nextFloat();
		controladorT.nPrecoCafe(o);
	}
}
