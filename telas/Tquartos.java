package telas;

import java.util.ArrayList;
import java.util.Scanner;

import controladores.Cquartos;

public class Tquartos {
	static Cquartos controladorQ = Cquartos.getInstance();
	static ArrayList<String> quartos = new ArrayList<String>();

	public static void Inicio() {
		int op = 1;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (op != 0) {
			System.out.println("Digite (1) para alterar preço dos itens");
			System.out.println("Digite (2) para alterar o numero do quarto");
			System.out.println("Digite (3) para adicionar um novo quarto");
			System.out.println("Digite (4) para listar os quartos");
			System.out.println("Digite (5) adicionar item a um quarto");
			System.out.println("Digite (0) para sair");
			op = sc.nextInt();
			switch (op) {
			case 1:
				controladorQ.precoItens();
				break;
			case 2:
				controladorQ.alterarNumero();
				break;
			case 3:
				controladorQ.addQuarto();
				break;
			case 4:
				controladorQ.lQuartos();
				break;
			case 5:
				controladorQ.addItem();
				break;
			case 0:
				break;
			}

		}
	}

	public static void precoItem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome do item");
		String nome = sc.next();
		System.out.println("Digite o novo valor do item");
		float nValor = sc.nextFloat();
		controladorQ.nPrecoItem(nome, nValor);
	}

	public static void alterarNumQuarto() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o antigo numero do quarto");
		int num = sc.nextInt();
		System.out.println("Digite o novo numero do quarto");
		int newNum = sc.nextInt();
		controladorQ.newNum(num, newNum);
	}

	public static void listarQuarto() {
		quartos = controladorQ.contQuartos();
		for (int x = 0; x < quartos.size(); x++) {
			System.out.println(quartos.get(x));
		}
	}

	public static void newQuarto() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o Numero do quarto");
		String nome = sc.next();
		controladorQ.newQuarto(nome);
	}

	public static void addItem() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite o nome do item");
		String nome = sc.next();
		System.out.println("Digite o nÃºmero do quarto");
		String nquarto = sc.next();
		if (Cquartos.addItem(nome, nquarto) == 0)
			System.out.println("Item adicionado");
		else
			System.out.println("erro ao adicionar item");
	}

}
