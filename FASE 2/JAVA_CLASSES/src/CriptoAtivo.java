// MATHEUS
public class CriptoAtivo {
    private int id;
    private String nome;
    private String sigla;
    private double precoAtual;
    private double marketCap;
    private double volumeTransacoes;
    private int anoCriacao;

    //Construtor
    public CriptoAtivo(int id, String nome, String sigla, double precoAtual, double marketCap, double volumeTransacoes, int anoCriacao) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.precoAtual = precoAtual;
        this.marketCap = marketCap;
        this.volumeTransacoes = volumeTransacoes;
        this.anoCriacao = anoCriacao;
    }

    //Metodo para atualizar o preço
    public void atualizarPreco(double novoPreco) {
        this.precoAtual = novoPreco;
    }

    //Metodo para o calculo do preço com base em um valor anterior
    public double calcularVariacao(double precoAnterior) {
        if (precoAnterior == 0) {
            return 0;
        }
        return ((precoAtual - precoAnterior) / precoAnterior) * 100;
    }

    //Getters e Setters
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getNome() {return nome;}

    public void setNome(String nome) {this.nome = nome;}

    public String getSigla() {return sigla;}

    public void setSigla(String sigla) {this.sigla = sigla;}

    public double getPrecoAtual() {return precoAtual;}

    public double getMarketCap() {return marketCap;}

    public void setMarketCap(double marketCap) {this.marketCap = marketCap;}

    public double getVolumeTransacoes() {return volumeTransacoes;}

    public void setVolumeTransacoes(double volumeTransacoes) {this.volumeTransacoes = volumeTransacoes;}

    public int getAnoCriacao() {return anoCriacao;}

    public void setAnoCriacao(int anoCriacao) {this.anoCriacao = anoCriacao;}
}