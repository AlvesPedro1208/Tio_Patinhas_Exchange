public class AlertaSeguranca extends Alerta {
    protected Carteira carteira;

    public AlertaSeguranca(int id, Usuario usuario, Carteira carteira, String condicao, String mensagem, boolean ativo) {
        super(id, usuario, null, condicao, mensagem, ativo); // Sem CriptoAtivo específico
        this.carteira = carteira;
    }

    public void verificarSeguranca() {
        if (carteira.getValorTotal() > 100000) { // Exemplo: alerta se saldo for muito alto
            ativo = true;
            mensagem = "Alerta de segurança: saldo elevado na carteira!";
            enviarNotificacao();
        }
    }
    @Override
    public void enviarNotificacao() {
        if (ativo && usuario != null && carteira != null) {
            System.out.println("⚠️ Alerta de Segurança ⚠️");
            System.out.println("Usuário: " + usuario.getNome());
            System.out.println("Saldo da carteira: R$" + carteira.getValorTotal());
            System.out.println("Condição do alerta: " + condicao);
            System.out.println("Mensagem: " + mensagem);
        } else {
            System.out.println("Erro: Usuário ou Carteira não definidos corretamente!");
        }
    }
}