package objetos;

import java.util.Comparator;
import java.util.Calendar;

public class Reserva {

    private static int contador = 0;
    private static float porcentagemR = 0.1F;
    private float valorTotal;
    private float valorPago = 0;
    private Calendar dataEntrada;
    private Calendar dataSaida;
    private boolean cafe;
    private Quarto quarto;
    private final String id;
    private static float vCafe;
    private boolean checkIn;

    public Reserva(Calendar entrada, Calendar saida, boolean cafe, Quarto quarto) {
        checkIn = false;
        contador++;
        dataEntrada = entrada;
        dataSaida = saida;
        this.cafe = cafe;
        id = "re" + contador;
        this.quarto = quarto;
        valorTotal = getValorTotal();
    }

    public Calendar getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Calendar dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Calendar getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(Calendar dataSaida) {
        this.dataSaida = dataSaida;
    }

    public boolean isCafe() {
        return cafe;
    }

    public void setCafe(boolean cafe) {
        this.cafe = cafe;
    }

    public String getId() {
        return id;
    }

    public float getValorDiaria() {
        return calculaValorDiaria();
    }

    private float calculaValorDiaria() {
        return cafe ? vCafe + Quarto.getPrecoBase() + quarto.getValor() : Quarto.getPrecoBase() + quarto.getValor();
    }

    public float getValorTotal() {
        return getValorDiaria() * (dataSaida.getTimeInMillis() + dataEntrada.getTimeInMillis()) / 86400000;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public static float getvCafe() {
        return vCafe;
    }

    public static void setvCafe(float vCafe) {
        Reserva.vCafe = vCafe;
    }

    public void realizarPagamento(float v) {
        if (v + valorPago <= valorTotal) {
            valorTotal = v + valorPago;
        }
    }

    public float getPagamentoInicial() {
        return porcentagemR * valorTotal;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public static float getPorcentagemR() {
        return porcentagemR;
    }

    public static void setPorcentagemR(float porcentagemR) {
        Reserva.porcentagemR = porcentagemR;
    }
    
    
}
