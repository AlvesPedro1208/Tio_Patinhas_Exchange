import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("--- 1. Criando o mercado de Criptoativos com HashMa p ---");
            HashMap<String, CriptoAtivo> mercadoCripto = new HashMap<>();
            mercadoCripto.put("BTC", new CriptoAtivo(1, "Bitcoin", "BTC", 50000.0, 900_000_000, 80_000_000, 2009));
            mercadoCripto.put("ETH", new CriptoAtivo(2, "Ethereum", "ETH", 3000.0, 400_000_000, 50_000_000, 2015));
            mercadoCripto.put("ADA", new CriptoAtivo(3, "Cardano", "ADA", 2.5, 150_000_000, 45_000_000, 2017));

            for (String sigla : mercadoCripto.keySet()) {
                System.out.println("-> Ativo disponível: " + mercadoCripto.get(sigla).getNome() + " (" + sigla + ")");
            }

            ArrayList<Usuario> usuarios = new ArrayList<>();
            usuarios.add(new Usuario(101, "Matheus", "matheus@email.com", "senha123", LocalDateTime.now(), new ArrayList<>(), new ArrayList<>()));
            usuarios.add(new Usuario(102, "Pedro", "pedro@email.com", "senha456", LocalDateTime.now(), new ArrayList<>(), new ArrayList<>()));
            usuarios.add(new Usuario(103, "Giovanna", "giovanna@email.com", "senha789", LocalDateTime.now(), new ArrayList<>(), new ArrayList<>()));
            usuarios.add(new Usuario(104, "Lucas", "lucas@email.com", "senha101", LocalDateTime.now(), new ArrayList<>(), new ArrayList<>()));
            usuarios.add(new Usuario(105, "Leandro", "leandro@email.com", "senha112", LocalDateTime.now(), new ArrayList<>(), new ArrayList<>()));

            System.out.println("\n--- 2. Preparando o sistema de carteiras com HashMap ---");
            HashMap<Integer, Carteira> carteirasPorUsuario = new HashMap<>();

            System.out.println("\n--- 3. Simulando operações para cada usuário ---");

            for (Usuario usuarioAtual : usuarios) {
                System.out.println("\n>>> Processando para o usuário: " + usuarioAtual.getNome() + " <<<");

                CriptoAtivo bitcoin = mercadoCripto.get("BTC");
                CriptoAtivo ethereum = mercadoCripto.get("ETH");

                Carteira carteira = new Carteira(usuarioAtual.getId(), usuarioAtual, new HashMap<>(), 0.0);
                carteirasPorUsuario.put(usuarioAtual.getId(), carteira);

                carteira.getAtivos().put(bitcoin, 2.0);
                carteira.getAtivos().put(ethereum, 5.0);
                carteira.atualizarSaldo();
                System.out.println("Carteira criada e armazenada. Valor total: R$" + String.format("%.2f", carteira.getValorTotal()));

                Transacao transacao1 = new Transacao(1, usuarioAtual, bitcoin, "Compra", 1.0, 50000.0, LocalDateTime.now());
                Transacao transacao2 = new Transacao(2, usuarioAtual, ethereum, "Compra", 3.0, 3000.0, LocalDateTime.now());
                usuarioAtual.getTransacoes().add(transacao1);
                usuarioAtual.getTransacoes().add(transacao2);
            }

            System.out.println("\n--- 4. Acessando dados com HashMap ---");

            System.out.println("Buscando informações do Ethereum (ETH) diretamente do mercado...");
            CriptoAtivo ethInfo = mercadoCripto.get("ETH");
            if (ethInfo != null) {
                System.out.println("Nome: " + ethInfo.getNome() + ", Preço Atual: R$" + ethInfo.getPrecoAtual());
            }

            int idUsuarioBusca = 101;
            System.out.println("\nBuscando a carteira do usuário com ID " + idUsuarioBusca + "...");
            Carteira carteiraGiovanna = carteirasPorUsuario.get(idUsuarioBusca);
            if (carteiraGiovanna != null) {
                System.out.println("Carteira encontrada! Valor total: R$" + String.format("%.2f", carteiraGiovanna.getValorTotal()));
            }

            System.out.println("\n--- Simulação concluída com sucesso! ---");

        } catch (Exception e) {
            System.out.println("Erro ao executar a simulação: " + e.getMessage());
            e.printStackTrace();
        }
    }
}