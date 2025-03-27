import java.time.LocalDateTime;
import java.util.List;

// GI
public class Usuario {

    // atributos
    private int id;
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime dataCriacao;
    private List<CriptoAtivo> moedas;
    private List<Transacao> transacoes;

    // construtores
    public Usuario() {
    }
    public Usuario(int id, String nome, String email, String senha, LocalDateTime dataCriacao, List<CriptoAtivo> moedas, List<Transacao> transacoes) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dataCriacao = dataCriacao;
        this.moedas = moedas;
        this.transacoes = transacoes;
    }

    // métodos

    public boolean autenticar(String email, String senha) {
        if (this.email.equals(email) && this.senha.equals(senha)) {
            System.out.println("Usuário autenticado com sucesso.");
            return true;
        } else {
            System.out.println("Falha na autenticação: email ou senha inválidos.");
            return false;
        }
    }

    public void visualizarDashboard() {
        System.out.println("=== Dashboard do Usuário ===");
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
        System.out.println("Data de Criação: " + this.dataCriacao);
        System.out.println("Quantidade de Criptoativos: "
                + (moedas != null ? moedas.size() : 0));
        System.out.println("Quantidade de Transações: "
                + (transacoes != null ? transacoes.size() : 0));
        System.out.println("================================\n");
    }

    public void gerarRelatorio() {
        System.out.println("Gerando relatório...");
    }

    public void simularInvestimento() {
        System.out.println("Simulando investimento...");
    }

    // getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<CriptoAtivo> getMoedas() {
        return moedas;
    }

    public void setMoedas(List<CriptoAtivo> moedas) {
        this.moedas = moedas;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
