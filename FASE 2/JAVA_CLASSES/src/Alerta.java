// MATHEUS
public class Alerta {
    protected int id;
    protected Usuario usuario;
    protected CriptoAtivo cripto;
    protected String condicao;
    protected String mensagem;
    protected boolean ativo;

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
        if (ativo && usuario != null) {
            System.out.println("Notificação para " + usuario.getNome() + ": " + mensagem);
        }
    }

    //Metodo pare enviar notificacao via e-mail
    public void enviarNotificacao(boolean viaEmail) {
        if (ativo && usuario != null) {
            if (viaEmail) {
                System.out.println("Enviando e-mail para " + (usuario.getEmail() != null ? usuario.getEmail() : "E-mail não definido") + " com mensagem: " + mensagem);
            } else {
                enviarNotificacao();
            }
        }
    }
}