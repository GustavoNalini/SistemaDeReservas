public class Avaliacao {
    private Usuario usuario;
    private int pontuacao;
    private String comentario;

    public Avaliacao(Usuario usuario, int pontuacao, String comentario) {
        this.usuario = usuario;
        this.pontuacao = pontuacao;
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
