package controladores;

import telas.Thotel;

public class Chotel {

private static Chotel cHotel;
private Cprincipal cPrincipal = Cprincipal.getInstance();
	private Chotel() {
	
	}
	public static Chotel getInstance() {
		if (cHotel == null) {
			cHotel = new Chotel();
		}
		return cHotel;
	}
	public void view() {
		Thotel.Inicio();
	}
	public void precoBaseReserva() {
		Thotel.precoReserva();
	}
	public void nPrecoReserva(float preco) {
		cPrincipal.alterarPrecoReserva(preco);
	}
	public void precoBaseCafe() {
		Thotel.precoCafe();
	}
	public void nPrecoCafe(float preco) {
		//cPrincipal.alterarPrecoCafe(preco);
	}
}
