import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RelatorioFinanceiro {
    int id;
    Usuario usuario;
    LocalDateTime dataGeracao;
    double rentabilidade;
    double investimentoTotal;
    Map<CriptoAtivo, Map<String, Double>> ativosDetalhados;

    public RelatorioFinanceiro(Usuario usuario) {
        this.usuario = usuario;
        this.dataGeracao = LocalDateTime.now();
        this.ativosDetalhados = new HashMap<>();
    }

    public void gerarRelatorioFinanceiro(Carteira carteira, Map<CriptoAtivo, Double> precoCompra) {
        this.investimentoTotal = 0;
        double valorAtualTotal = 0;

        for (Map.Entry<CriptoAtivo, Double> entry : carteira.getAtivos().entrySet()) {
            CriptoAtivo ativo = entry.getKey();
            double quantidade = entry.getValue();
            double precoAtual = ativo.getPrecoAtual();
            double precoInicial = precoCompra.getOrDefault(ativo, precoAtual); // fallback

            double valorInvestido = precoInicial * quantidade;
            double valorAtual = precoAtual * quantidade;
            double variacao = ((valorAtual - valorInvestido) / valorInvestido) * 100;

            Map<String, Double> detalhes = new HashMap<>();
            detalhes.put("quantidade", quantidade);
            detalhes.put("valorInvestido", valorInvestido);
            detalhes.put("valorAtual", valorAtual);
            detalhes.put("variacaoPercentual", variacao);

            ativosDetalhados.put(ativo, detalhes);

            investimentoTotal += valorInvestido;
            valorAtualTotal += valorAtual;
        }

        calcularRentabilidade(valorAtualTotal);
    }

    public void calcularRentabilidade(double valorAtualTotal) {
        if (investimentoTotal > 0) {
            this.rentabilidade = ((valorAtualTotal - investimentoTotal) / investimentoTotal) * 100;
        } else {
            this.rentabilidade = 0;
        }
    }

    public void imprimirRelatorio() {
        System.out.println("Relatório de Investimentos - " + dataGeracao);
        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Investimento Total: R$" + investimentoTotal);
        System.out.println("Rentabilidade: " + rentabilidade + "%");
        System.out.println("Detalhamento por Ativo:");

        for (Map.Entry<CriptoAtivo, Map<String, Double>> entry : ativosDetalhados.entrySet()) {
            CriptoAtivo ativo = entry.getKey();
            Map<String, Double> detalhes = entry.getValue();
            System.out.println("Ativo: " + ativo.getNome() + " (" + ativo.getSigla() + ")");
            System.out.println("  Quantidade: " + detalhes.get("quantidade"));
            System.out.println("  Valor Investido: R$" + detalhes.get("valorInvestido"));
            System.out.println("  Valor Atual: R$" + detalhes.get("valorAtual"));
            System.out.println("  Variação: " + detalhes.get("variacaoPercentual") + "%");
        }
    }
}