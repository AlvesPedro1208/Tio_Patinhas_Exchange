// MATHEUS
public class Alerta {
    private int id;
    private Usuario usuario;
    private CriptoAtivo cripto;
    private String condicao;
    private String mensagem;
    private boolean ativo;

    //Construtor
    public Alerta(int id, Usuario usuario, CriptoAtivo cripto, String condicao, String mensagem, boolean ativo) {
        this.id = id;
        this.usuario = usuario;
        this.cripto = cripto;
        this.condicao = condicao;
        this.mensagem = mensagem;
        this.ativo = ativo;
    }

    //Metodo para verificar condicao do alerta
    public boolean verificarCondicao(double precoAtual) {
        return condicao.equals("acima") && precoAtual > cripto.getPrecoAtual() ||
                condicao.equals("abaixo") && precoAtual < cripto.getPrecoAtual();
    }

    //Metodo pare enviar notificacao
    public void enviarNotificacao() {
        if (ativo) {
            System.out.println("Notificação para " + usuario.getNome() + ": " + mensagem);
        }
    }

    //Getters e Setters
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public Usuario getUsuario() {return usuario;}

    public void setUsuario(Usuario usuario) {this.usuario = usuario;}

    public CriptoAtivo getCripto() {return cripto;}

    public void setCripto(CriptoAtivo cripto) {this.cripto = cripto;}

    public String getCondicao() {return condicao;}

    public void setCondicao(String condicao) {this.condicao = condicao;}

    public String getMensagem() {return mensagem;}

    public void setMensagem(String mensagem) {this.mensagem = mensagem;}

    public boolean isAtivo() {return ativo;}

    public void setAtivo(boolean ativo) {this.ativo = ativo;}
}