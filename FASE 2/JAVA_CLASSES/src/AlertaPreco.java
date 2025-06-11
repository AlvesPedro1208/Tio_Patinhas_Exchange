public class AlertaPreco extends Alerta {
    protected double precoAlvo;

    public AlertaPreco(int id, Usuario usuario, CriptoAtivo cripto, double precoAlvo, String condicao, String mensagem, boolean ativo) {
        super(id, usuario, cripto, condicao, mensagem, ativo);
        this.precoAlvo = precoAlvo;
    }

    public void verificarPreco() {
        if ((cripto.getPrecoAtual() >= precoAlvo && condicao.equals("acima")) ||
                (cripto.getPrecoAtual() <= precoAlvo && condicao.equals("abaixo"))) {
            ativo = true;
            mensagem = "Alerta de preço: " + cripto.getNome() + " atingiu " + precoAlvo;
            enviarNotificacao();
        }
    }

    @Override
    public void enviarNotificacao() {
        if (ativo && usuario != null && cripto != null) {
            System.out.println("🚨 Alerta de Preço 🚨");
            System.out.println("Criptoativo: " + cripto.getNome());
            System.out.println("Preço alvo atingido: " + precoAlvo);
            System.out.println("Condição: " + condicao);
            System.out.println("Mensagem: " + mensagem);
            System.out.println("Usuário: " + usuario.getNome());
        }
    }
}