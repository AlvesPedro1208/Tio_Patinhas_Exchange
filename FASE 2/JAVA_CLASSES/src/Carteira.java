import java.util.HashMap;
import java.util.Map;

public class Carteira {
    private int id;
    private Usuario usuario;
    private Map<CriptoAtivo, Double> ativos;
    private double valorTotal;

    public Carteira(int id, Usuario usuario, Map<CriptoAtivo, Double> ativos, double valorTotal) {
        this.id = id;
        this.usuario = usuario;
        this.ativos = ativos;
        this.valorTotal = valorTotal;
    }

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

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Map<CriptoAtivo, Double> getAtivos() {
        return ativos;
    }

    public void setAtivos(Map<CriptoAtivo, Double> ativos) {
        this.ativos = ativos;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
