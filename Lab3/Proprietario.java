import java.util.ArrayList;
import java.util.List;


class Proprietario extends Usuario {
    private List<Propriedade> propriedades;

    public Proprietario(String nome, String senha) {
        super(nome, senha);
        this.propriedades = new ArrayList<>();
    }

    public void mostrarPropriedade() {
        if (propriedades.isEmpty()) {
            System.out.println("Nenhuma propriedade cadastrada.");
        } else {
            for (Propriedade propriedade : propriedades) {
                propriedade.mostrarDetalhes(); 
            }
        }
    }

    public Propriedade addPropriedade(Propriedade propriedade) {
        propriedades.add(propriedade);
        return propriedade;
    }

    @Override
    public void mostrarInformacoes() {
        System.out.println("Proprietário: " + getNome());
        mostrarPropriedade();
    }
}
