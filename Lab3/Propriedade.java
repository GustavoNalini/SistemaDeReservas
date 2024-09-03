abstract class Propriedade {
  private String titulo;
  private String descricao;
  private String localidade;
  private double precoNoite;
  private boolean disponivel;

  public Propriedade(String titulo, String descricao, String localidade, double precoNoite, boolean disponivel) {
      this.titulo = titulo;
      this.descricao = descricao;
      this.localidade = localidade;
      this.precoNoite = precoNoite;
      this.disponivel = disponivel;
  }

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

  public abstract void mostrarDetalhes();
}
