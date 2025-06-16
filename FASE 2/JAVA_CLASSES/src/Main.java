import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println("\n--- 1. Carregando dados a partir de arquivos CSV ---");
        HashMap<String, CriptoAtivo> mercadoCripto = carregarCriptoativosDeCSV("criptoativos.csv");
        ArrayList<Usuario> usuarios = carregarUsuariosDeCSV("usuarios.csv");

        if (mercadoCripto.isEmpty() || usuarios.isEmpty()) {
            System.err.println("Falha ao carregar dados. Encerrando a simulação.");
            return;
        }

        System.out.println(mercadoCripto.size() + " criptoativos carregados.");
        System.out.println(usuarios.size() + " usuários carregados.");

        System.out.println("\n--- 2. Simulando operações para cada usuário ---");
        HashMap<Integer, Carteira> carteirasPorUsuario = new HashMap<>();

        for (Usuario usuarioAtual : usuarios) {
            System.out.println("\n>>> Processando para o usuário: " + usuarioAtual.getNome() + " <<<");

            CriptoAtivo bitcoin = mercadoCripto.get("BTC");
            CriptoAtivo ethereum = mercadoCripto.get("ETH");

            if (bitcoin == null || ethereum == null) {
                System.err.println("BTC ou ETH não encontrados no mercado. Pulando usuário.");
                continue;
            }

            Carteira carteira = new Carteira(usuarioAtual.getId(), usuarioAtual, new HashMap<>(), 0.0);
            carteirasPorUsuario.put(usuarioAtual.getId(), carteira);

            carteira.getAtivos().put(bitcoin, 2.0);
            carteira.getAtivos().put(ethereum, 5.0);
            carteira.atualizarSaldo();
            System.out.println("Carteira criada e armazenada. Valor total: R$" + String.format("%.2f", carteira.getValorTotal()));
        }

        System.out.println("\n--- 3. Salvando relatório de carteiras em arquivo de texto ---");
        salvarRelatorioCarteiras(carteirasPorUsuario);

        System.out.println("\n--- Simulação concluída com sucesso! ---");
    }

    public static HashMap<String, CriptoAtivo> carregarCriptoativosDeCSV(String nomeArquivo) {
        HashMap<String, CriptoAtivo> mercado = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String sigla = dados[2];
                double preco = Double.parseDouble(dados[3]);
                double marketCap = Double.parseDouble(dados[4]);
                double volume = Double.parseDouble(dados[5]);
                int ano = Integer.parseInt(dados[6]);

                CriptoAtivo ativo = new CriptoAtivo(id, nome, sigla, preco, marketCap, volume, ano);
                mercado.put(sigla, ativo);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao carregar criptoativos do arquivo " + nomeArquivo + ": " + e.getMessage());
        }
        return mercado;
    }

    public static ArrayList<Usuario> carregarUsuariosDeCSV(String nomeArquivo) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String email = dados[2];
                String senha = dados[3];
                LocalDateTime dataCriacao = LocalDateTime.parse(dados[4]);

                Usuario usuario = new Usuario(id, nome, email, senha, dataCriacao, new ArrayList<>(), new ArrayList<>());
                usuarios.add(usuario);
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Erro ao carregar usuários do arquivo " + nomeArquivo + ": " + e.getMessage());
        }
        return usuarios;
    }

    public static void salvarRelatorioCarteiras(HashMap<Integer, Carteira> carteiras) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("relatorio_carteiras.txt"))) {
            writer.println("### RELATÓRIO DE CARTEIRAS DE CLIENTES ###");
            for (Carteira c : carteiras.values()) {
                writer.println("\n=============================================");
                writer.printf(">> CARTEIRA DO USUÁRIO: %s (ID: %d)\n", c.getUsuario().getNome(), c.getUsuario().getId());
                writer.println("---------------------------------------------");
                for (Map.Entry<CriptoAtivo, Double> ativoEntry : c.getAtivos().entrySet()) {
                    writer.printf("  - Ativo: %s (%s) | Quantidade: %.2f\n",
                            ativoEntry.getKey().getNome(), ativoEntry.getKey().getSigla(), ativoEntry.getValue());
                }
                writer.printf("VALOR TOTAL DA CARTEIRA: R$ %.2f\n", c.getValorTotal());
            }
            System.out.println("Arquivo 'relatorio_carteiras.txt' salvo com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever o relatório de carteiras: " + e.getMessage());
        }
    }

}