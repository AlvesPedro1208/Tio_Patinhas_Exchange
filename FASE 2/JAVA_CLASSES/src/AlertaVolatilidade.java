public class AlertaVolatilidade extends Alerta {
    protected double percentualVariacao;

    public AlertaVolatilidade(int id, Usuario usuario, CriptoAtivo cripto, double percentualVariacao, String condicao, String mensagem, boolean ativo) {
        super(id, usuario, cripto, condicao, mensagem, ativo);
        this.percentualVariacao = percentualVariacao;
    }

    public void verificarVolatilidade(double precoAnterior) {
        double variacao = cripto.calcularVariacao(precoAnterior);
        if (Math.abs(variacao) >= percentualVariacao) {
            ativo = true;
            mensagem = "Alerta de volatilidade: " + cripto.getNome() + " variou " + variacao + "%";
            enviarNotificacao();
        }
    }

    @Override
    public void enviarNotificacao() {
        if (ativo && usuario != null && cripto != null) {
            System.out.println("📈 Alerta de Volatilidade 📉");
            System.out.println("Criptoativo: " + cripto.getNome());
            System.out.println("Variação extrema detectada: " + percentualVariacao + "%");
            System.out.println("Condição do alerta: " + condicao);
            System.out.println("Mensagem: " + mensagem);
            System.out.println("Usuário: " + usuario.getNome());
        } else {
            System.out.println("Erro: Usuário ou Criptoativo não definidos corretamente!");
        }
    }
}