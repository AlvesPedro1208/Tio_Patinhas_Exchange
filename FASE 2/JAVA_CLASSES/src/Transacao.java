import java.time.LocalDateTime;

// GI
public class Transacao {

    // atributos
    private int id;
    private Usuario usuario;
    private CriptoAtivo criptoAtivo;
    private String tipo;
    private double quantidade;
    private double valorUnitario;
    private LocalDateTime data;

    // contrutores
    public Transacao() {
    }

    public Transacao(int id, Usuario usuario, CriptoAtivo criptoAtivo, String tipo, double quantidade, double valorUnitario, LocalDateTime data) {
        this.id = id;
        this.usuario = usuario;
        this.criptoAtivo = criptoAtivo;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.data = data;
    }

    // métodos
    private void calcularValorTotal() {
        double valorTotal = quantidade * valorUnitario;
        System.out.println("Valor total da transação: " + valorTotal);
    }

    private void registrarTransacao() {
        // Exemplo: chamando o método calcularValorTotal() dentro de registrarTransacao
        calcularValorTotal();

        // Exemplo: exibindo informações da transação
        System.out.println("Registrando transação...");
        System.out.println("ID: " + id);
        System.out.println("Usuário: " + (usuario != null ? usuario.getNome() : "Usuário não definido"));
        System.out.println("CriptoAtivo: " + (criptoAtivo != null ? criptoAtivo.getNome() : "CriptoAtivo não definido"));
        System.out.println("Tipo: " + tipo);
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Valor Unitário: " + valorUnitario);
        System.out.println("Data: " + data);
        System.out.println("Transação registrada com sucesso!");

    }

    // getters e setters
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

    public CriptoAtivo getCriptoAtivo() {
        return criptoAtivo;
    }

    public void setCriptoAtivo(CriptoAtivo criptoAtivo) {
        this.criptoAtivo = criptoAtivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
