package controladores;

import java.util.ArrayList;

import objetos.Item;
import objetos.Quarto;
import subItens.Tv;
import telas.Tquartos;

public class Cquartos {

    private static Cquartos cQuartos;

    private Cprincipal cPrincipal = Cprincipal.getInstance();

    private Cquartos() {

    }

    public static Cquartos getInstance() {
        if (cQuartos == null) {
            cQuartos = new Cquartos();
        }
        return cQuartos;
    }

    public int nPrecoItem(String nome, float nValor) {
        Item i = Item.getInstance(nome);
        if (i == null) {
            return 1;
        }
        i.setValor(nValor);
        return 0;
    }

    void view() {
        Tquartos.Inicio();
    }

    public void precoItens() {
        Tquartos.precoItem();
    }

    public void alterarNumero() {
        Tquartos.alterarNumQuarto();
    }

    public int newNum(Integer num, Integer newNum) {
        Quarto q = cPrincipal.getQuarto(num.toString());
        if (q == null) {
            return 1;
        }
        q.setNumero(newNum.toString());
        cPrincipal.removeQuarto(num.toString());
        cPrincipal.putQuarto(q);
        return 0;
    }

    public void lQuartos() {
        Tquartos.listarQuarto();
    }

    public void addQuarto() {
        Tquartos.newQuarto();
        
        
    }

    public ArrayList<String> contQuartos() {
        return cPrincipal.contQuartos();
    }

    public void newQuarto(String l) {
        Quarto q = new Quarto(l);
        cPrincipal.putQuarto(q);
    }

    public void addItem() {
        Tquartos.addItem();
    }

    public static int addItem(String nome, String nQuarto) {
        Cprincipal c = Cprincipal.getInstance();
        Quarto q = c.getQuarto(nQuarto);
        if(q==null)
            return 1;
        q.addItem(Item.getInstance(nome));
        return 0;
    }
}
