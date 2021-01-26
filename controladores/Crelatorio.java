/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.Calendar;
import objetos.Reserva;
import telas.Trelatorio;

/**
 *
 * @author bruno
 */
public class Crelatorio {
    private static Crelatorio crelatorio;
    
    private Crelatorio() {

    }

    public static Crelatorio getInstance() {
        if (crelatorio == null) {
            crelatorio = new Crelatorio();
        }
        return crelatorio;
    }

    public void view() {
        Trelatorio.inicio();
    }
    
    public float getRelatorioMensal(int mes, int ano, Boolean t){
        Cprincipal c =  Cprincipal.getInstance();
        float valorR = 0, valorP = 0;        
        if(t)
            return c.getRPValues().stream().filter((r1) -> (r1.getDataEntrada().get(Calendar.MONTH) == (mes-1) && r1.getDataEntrada().get(Calendar.YEAR) == (ano))).map((r1) -> r1.getValorPago()).reduce(valorP, (accumulator, _item) -> accumulator + _item);
        
        return c.getRCValues().stream().filter((r1) -> (r1.getDataEntrada().get(Calendar.MONTH) == (mes-1) && r1.getDataEntrada().get(Calendar.YEAR) == (ano))).map((r1) -> r1.getValorPago()).reduce(valorR, (accumulator, _item) -> accumulator + _item);
    }
    
    public float getRelatorioAnual(int ano, Boolean t){
        Cprincipal c =  Cprincipal.getInstance();
        float valorR = 0, valorP = 0;        
        if(t)
            return c.getRPValues().stream().filter((r1) -> (r1.getDataEntrada().get(Calendar.YEAR) == (ano))).map((r1) -> r1.getValorPago()).reduce(valorP, (accumulator, _item) -> accumulator + _item);
        
        return c.getRCValues().stream().filter((r1) -> (r1.getDataEntrada().get(Calendar.YEAR) == (ano))).map((r1) -> r1.getValorPago()).reduce(valorR, (accumulator, _item) -> accumulator + _item);
    }

    public void relatorioAno() {
        Trelatorio.perguntaAno();
    }

    public void relatorioMes() {
        Trelatorio.perguntaMes();
    }
}
