import java.util.ArrayList;
import java.util.List;

class Cliente extends Usuario {
    private List<Reserva> reservas;

    public Cliente(String nome, String senha) {
        super(nome, senha);
        this.reservas = new ArrayList<>();
    }

    public void fazerReserva(Reserva reserva) {
        reservas.add(reserva);
        System.out.println("Reserva feita com sucesso para a propriedade: " + reserva.getPropriedade().getTitulo());
    }

    public List<Reserva> listarReservas() {
        return reservas;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Cliente: " + getNome());
        if (reservas.isEmpty()) {
            System.out.println("Nenhuma reserva feita.");
        } else {
            for (Reserva reserva : reservas) {
                System.out.println("- Propriedade: " + reserva.getPropriedade().getTitulo());
                System.out.println("  Data de Início: " + reserva.getDataInicial());
                System.out.println("  Data Final: " + reserva.getDataFinal());
                System.out.println("  Custo Total: " + reserva.getCustoTotal());
            }
        }
    }
}
