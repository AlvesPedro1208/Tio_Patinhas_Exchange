import java.util.HashMap;
import java.util.Map;

public class Carteira {
    int id;
    Usuario usuario;
    Map<CriptoAtivo, Double> ativos;
    private double valorTotal;

    public double calcularValorTotal() {
        double valorTotal = 0;
        for (Map.Entry<CriptoAtivo, Double> entry : ativos.entrySet()) {
            CriptoAtivo ativo = entry.getKey();
            double quantidade = entry.getValue();
            valorTotal += quantidade * ativo.getPrecoAtual();
        }
        return valorTotal;
    }

    public void atualizarSaldo() {
        double total = 0;
        for (Map.Entry<CriptoAtivo, Double> entry : ativos.entrySet()) {
            total += entry.getValue() * entry.getKey().getPrecoAtual();
        }
        this.valorTotal = total;
    }


    public Map<String, Double> gerarDadosValorizacao() {
        Map<String, Double> dados = new HashMap<>();
        for (Map.Entry<CriptoAtivo, Double> entry : ativos.entrySet()) {
            CriptoAtivo ativo = entry.getKey();
            double quantidade = entry.getValue();
            dados.put(ativo.getNome(), quantidade * ativo.getPrecoAtual());
        }
        return dados;
    }
}
