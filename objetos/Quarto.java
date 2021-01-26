package objetos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Quarto {

    private String numero;
    private static float precoBase;
    private HashMap<String, Item> itens = new HashMap<String, Item>();
    private ArrayList<Reserva> reservas = new ArrayList<Reserva>();

    public Quarto(String num) {
        numero = num;
        reservas.clear();
        itens.clear();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void addItem(Item a) {
        try {
            itens.put(a.getNome(), a);
        } catch (Exception e) {
            throw e;
        }

    }

    public Item removeItem(String a) {
        try {
            return itens.remove(a);
        } catch (Exception e) {
            throw e;
        }
    }

    public void addReserva(Reserva a) {
        try {
            reservas.add(a);
        } catch (Exception e) {
            throw e;
        }
    }

    public Reserva removeReserva(Reserva a) {
        try {
            return reservas.remove(reservas.indexOf(a));
        } catch (Exception e) {
            return null;
        }
    }
    
    public Reserva removeReserva(int i){
        return reservas.remove(i);
    }
    
    public Reserva getReserva(int a){
        return a>=reservas.size()?null:reservas.get(a);
    }

    public float getValor() {
        float temp = 0;
        for (Item i : itens.values()) {
            temp += i.getValor();
        }
        return temp;
    }

    public String conteudo() {
        int contB = 0, contI = 0, contT = 0, contCs = 0, contCc = 0;
        for (Item i : itens.values()) {
            if (i.getNome() == "Banheiro") {
                contB++;
            }
            if (i.getNome() == "Tv") {
                contT++;
            }
            if (i.getNome() == "Internet") {
                contI++;
            }
            if (i.getNome() == "CamaS") {
                contCs++;
            }
            if (i.getNome() == "CamaC") {
                contCc++;
            }
        }
        return "Quarto:" + this.numero + " Banheiro:" + contB + " Tv:" + contT + " Internet:" + contI + " Cama Solteiro:" + contCs + " Cama Casal:" + contCc;
    }

    public class ReservaComparator implements Comparator<Reserva> {

        public int compare(Reserva a, Reserva b) {
            return a.getDataEntrada().compareTo(b.getDataEntrada());
        }
    }

    public void ordenaReservas() {
        Collections.sort(reservas, new ReservaComparator());
    }
    
    
    public static float getPrecoBase() {
        return precoBase;
    }

    public static void setPrecoBase(float precoBase) {
        Quarto.precoBase = precoBase;
    }

}
