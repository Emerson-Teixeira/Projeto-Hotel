package controladores;

import java.util.Calendar;
import objetos.Quarto;
import objetos.Reserva;
import telas.Treserva;

public class Creserva {

    private static Creserva cReserva;
    private Cprincipal cPrincipal = Cprincipal.getInstance();

    private Creserva() {

    }

    public static Creserva getInstance() {
        if (cReserva == null) {
            cReserva = new Creserva();
        }
        return cReserva;
    }

    public void view() {
        Treserva.Inicio();
    }

    public String nReserva(Calendar entrada, Calendar saida, Boolean cafe, String nQuarto) {
        Calendar atual = Calendar.getInstance();
        if (entrada.compareTo(atual) <= 0) {
            return null;
        } else if (saida.compareTo(entrada) <= 0) {
            return null;
        }
        Cprincipal c = Cprincipal.getInstance();
        Quarto q = c.getQuarto(nQuarto);
        if (q == null) {
            return null;
        }
        Reserva r = null;
        int i = 0;
        do {
            r = q.getReserva(i);
            if (r == null) {
                break;
            }
            if (r.getDataSaida().compareTo(entrada) <= 0) {
                i++;
                break;
            }
            i++;
        } while (true);
        r = q.getReserva(i);
        if (r != null) {
            if (r.getDataEntrada().compareTo(saida) < 0) {
                return null;
            }
        }
        r = new Reserva(entrada, saida, cafe, q);
        float pi = r.getPagamentoInicial();
        if (!Treserva.confirmarPagamento(pi)) {
            return null;
        }
        r.realizarPagamento(pi);
        q.addReserva(r);
        q.ordenaReservas();
        c.addReservaP(r);
        return r.getId();
    }

    public int altReserva(String idR, Calendar dataEntrada, Calendar dataSaida, Boolean cafe, String nQuarto) {
        Cprincipal c = Cprincipal.getInstance();
        Calendar atual = Calendar.getInstance();
        if (dataEntrada.compareTo(atual) <= 0) {
            return 1;
        } else if (dataSaida.compareTo(dataEntrada) <= 0) {
            return 1;
        }
        Quarto q = c.getQuarto(nQuarto);
        Reserva r = null;
        int i = 0;
        do {
            r = q.getReserva(i);
            if (r == null) {
                return 1;
            }
            if (r.getId().contentEquals(idR)) {
                i++;
                break;
            }
        } while (true);
        r.setCafe(cafe);
        r.setDataEntrada(dataEntrada);
        r.setDataSaida(dataSaida);
        r.setQuarto(q);
        return 0;
    }

    public int excReserva(String idR) {
        Cprincipal c = Cprincipal.getInstance();
        Reserva r = null;
        r = c.removeReservaP(idR);
        if (r == null) {
            return 1;
        }
        r.getQuarto().removeReserva(r);
        return 0;
    }

    public void criaR() {
        Treserva.criarReserva();
    }

    public void alteraR() {
        Treserva.alteraReserva();
    }

    public void excluiR() {
        Treserva.excluirReserva();

    }

    public void checkIn() {
        Treserva.PerguntaCheckIn();
    }

    public int ConfirmaCheckIn(String idR) {
        Cprincipal c = Cprincipal.getInstance();
        Reserva r = null;
        r = c.getReservaP(idR);
        if (r == null) {
            return 1;
        }
        r.setCheckIn(true);
        return 0;
    }

    public void checkOut() {
        Treserva.PerguntaCheckOut();
    }

    public int ConfirmaCheckOut(String idR) {
        Cprincipal c = Cprincipal.getInstance();
        Reserva r = null;
        r=c.getReservaP(idR);
        if (!Treserva.confirmarPagamento(r.getValorTotal()-r.getValorPago())) {
            return 1;
        }
        r = c.removeReservaP(idR);
        if (r == null) {
            return 1;
        }
        c.addReservaC(r);
        r.getQuarto().removeReserva(r);
        return 0;
    }

}
