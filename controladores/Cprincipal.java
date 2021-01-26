package controladores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import objetos.Quarto;
import objetos.Reserva;

public class Cprincipal {

    private static Cprincipal cPrincipal;
    private static Chotel cHotel = Chotel.getInstance();
    private static Cquartos cQuarto = Cquartos.getInstance();
    private static Creserva cReserva = Creserva.getInstance();
    private static Crelatorio cRelatorio = Crelatorio.getInstance();
    private HashMap<String, Quarto> quartos = new HashMap<String, Quarto>();
    private HashMap<String, Reserva> reservasPendentes = new HashMap<String, Reserva>();
    private HashMap<String, Reserva> reservasConcluidas = new HashMap<String, Reserva>();

    private Cprincipal() {
    }

    public static Cprincipal getInstance() {
        if (cPrincipal == null) {
            cPrincipal = new Cprincipal();
        }
        return cPrincipal;
    }

    public void gHotel() {
        cHotel.view();
    }

    public void gQuartos() {
        cQuarto.view();
    }

    public void gReserva() {
        cReserva.view();
    }
    
    public void gRelatorios() {
        cRelatorio.view();
    }

    public void alterarPrecoReserva(float preco) {
        Quarto.setPrecoBase(preco);
    }

    public void alterarPrecoCafe(float preco) {
        Reserva.setvCafe(preco);
    }

    public Quarto getQuarto(String a) {
        Quarto q = null;
        try {
            q = quartos.get(a);
        } catch (Exception e) {
            throw e;
        }
        return q;
    }

    public void removeQuarto(String a) {
        try {
            quartos.remove(a);
        } catch (Exception e) {
            throw e;
        }
    }

    public void putQuarto(Quarto a) {
        quartos.put(a.getNumero(), a);
    }

    public ArrayList<String> contQuartos() {
        ArrayList<String> conteudos = new ArrayList<String>();
        for (Quarto q : quartos.values()) {
            conteudos.add(q.conteudo());
        }
        return conteudos;
    }

    public void addReservaC(Reserva a) {
        try {
            reservasConcluidas.put(a.getId(), a);
        } catch (Exception e) {
            throw e;
        }
    }

    public Reserva removeReservaC(String i) {
        return reservasConcluidas.remove(i);
    }

    public Reserva getReservaC(String a) {
        return reservasConcluidas.get(a);
    }
    public void addReservaP(Reserva a) {
        try {
            reservasPendentes.put(a.getId(), a);
        } catch (Exception e) {
            throw e;
        }
    }

    public Reserva removeReservaP(String i) {
        return reservasPendentes.remove(i);
    }

    public Reserva getReservaP(String a) {
        return reservasPendentes.get(a);
    }
    
    public Collection<Reserva> getRPValues(){
        return reservasPendentes.values();
    }

    public Collection<Reserva> getRCValues(){
        return reservasConcluidas.values();
    }
}
