abstract class Propriedade {
  // Atributos da classe
  private String titulo;
  private String descricao;
  private String localidade;
  private double precoNoite;
  private boolean disponivel;

  // Construtor
  public Propriedade(String titulo, String descricao, String localidade, double precoNoite, boolean disponivel) {
      this.titulo = titulo;
      this.descricao = descricao;
      this.localidade = localidade;
      this.precoNoite = precoNoite;
      this.disponivel = disponivel;
  }

  // Métodos getters
  public String getTitulo() {
      return titulo;
  }

  public String getDescricao() {
      return descricao;
  }

  public String getLocalidade() {
      return localidade;
  }

  public double getPrecoNoite() {
      return precoNoite;
  }

  public boolean estaDisponivel() {
      return disponivel;
  }

  // Método abstrato
  public abstract void mostrarDetalhes();
}
