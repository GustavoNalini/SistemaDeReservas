class Apartamento extends Propriedade {
  private int andar;

  public Apartamento(String titulo, String descricao, String localidade, double precoNoite, boolean disponivel, int andar) {
      super(titulo, descricao, localidade, precoNoite, disponivel);
      this.andar = andar;
  }

  @Override
  public void mostrarDetalhes() {
      System.out.println("Apartamento: " + getTitulo());
      System.out.println("Descrição: " + getDescricao());
      System.out.println("Localidade: " + getLocalidade());
      System.out.println("Preço por Noite: " + getPrecoNoite());
      System.out.println("Andar: " + andar);
      System.out.println("Disponível: " + (estaDisponivel() ? "Sim" : "Não"));
  }
}
