class Casa extends Propriedade {
  private int numeroQuartos;
  private double taxaLimpeza; 

  public Casa(String titulo, String descricao, String localidade, double precoNoite, boolean disponivel, int numeroQuartos, double taxaLimpeza) {
      super(titulo, descricao, localidade, precoNoite, disponivel);
      this.numeroQuartos = numeroQuartos;
      this.taxaLimpeza = taxaLimpeza;  
     }

  public double getTaxaLimpeza() {
      return taxaLimpeza;
  }

  @Override
  public void mostrarDetalhes() {
      System.out.println("Casa: " + getTitulo());
      System.out.println("Descrição: " + getDescricao());
      System.out.println("Localidade: " + getLocalidade());
      System.out.println("Preço por Noite: " + getPrecoNoite());
      System.out.println("Número de Quartos: " + numeroQuartos);
      System.out.println("Taxa de Limpeza: " + taxaLimpeza);
      System.out.println("Disponível: " + (estaDisponivel() ? "Sim" : "Não"));
  }
}
