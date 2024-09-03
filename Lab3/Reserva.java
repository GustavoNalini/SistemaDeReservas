import java.time.LocalDate;

public class Reserva {
    private Propriedade propriedade;
    private Cliente cliente;
    private LocalDate dataInicial;
    private LocalDate dataFinal;
    private double custoTotal;

    public Reserva(Propriedade propriedade, Cliente cliente, LocalDate dataInicial, LocalDate dataFinal) {
        this.propriedade = propriedade;
        this.cliente = cliente;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
        this.custoTotal = calcularCustoTotal();
    }

    public LocalDate getDataInicial() {
        return dataInicial;
    }

    public LocalDate getDataFinal() {
        return dataFinal;
    }

    public Propriedade getPropriedade() {
        return propriedade;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    private double calcularCustoTotal() {
        long dias = dataInicial.until(dataFinal).getDays();
        double custo = dias * propriedade.getPrecoNoite();

        if (propriedade instanceof Casa) {
            Casa casa = (Casa) propriedade;
            custo += casa.getTaxaLimpeza();
        }

        return custo;
    }
}
