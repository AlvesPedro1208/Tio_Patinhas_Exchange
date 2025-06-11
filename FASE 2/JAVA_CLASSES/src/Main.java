import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try {
            // Criando um usuário
            Usuario usuario = new Usuario(1, "Matheus", "matheus@email.com", "senha123", LocalDateTime.now(), new ArrayList<>(), new ArrayList<>());
            System.out.println("Usuário criado com sucesso: " + usuario.getNome());

            // Criando criptoativos
            CriptoAtivo bitcoin = new CriptoAtivo(1, "Bitcoin", "BTC", 50000.0, 900_000_000, 80_000_000, 2009);
            CriptoAtivo ethereum = new CriptoAtivo(2, "Ethereum", "ETH", 3000.0, 400_000_000, 50_000_000, 2015);
            System.out.println("Criptoativos criados: " + bitcoin.getNome() + ", " + ethereum.getNome());

            // Criando carteira
            Carteira carteira = new Carteira(1, usuario, new HashMap<>(), 0.0);
            carteira.getAtivos().put(bitcoin, 2.0); // Usuário tem 2 Bitcoins
            carteira.getAtivos().put(ethereum, 5.0); // Usuário tem 5 Ethereums
            carteira.atualizarSaldo();
            System.out.println("Carteira criada. Valor total: R$" + carteira.getValorTotal());

            // Criando transações
            Transacao transacao1 = new Transacao(1, usuario, bitcoin, "Compra", 1.0, 50000.0, LocalDateTime.now());
            Transacao transacao2 = new Transacao(2, usuario, ethereum, "Compra", 3.0, 3000.0, LocalDateTime.now());
            usuario.getTransacoes().add(transacao1);
            usuario.getTransacoes().add(transacao2);
            System.out.println("Transações registradas.");

            // Criando alertas
            AlertaPreco alertaPreco = new AlertaPreco(1, usuario, bitcoin, 55000.0, "acima", "Bitcoin ultrapassou R$55.000!", false);
            AlertaSeguranca alertaSeguranca = new AlertaSeguranca(2, usuario, carteira, "saldo elevado", "Sua carteira tem um saldo muito alto!", false);
            AlertaVolatilidade alertaVolatilidade = new AlertaVolatilidade(3, usuario, ethereum, 5.0, "alta volatilidade", "Ethereum teve variação extrema!", false);

            System.out.println("Alertas criados.");

            // Simulando verificações de alertas
            alertaPreco.verificarPreco();
            alertaSeguranca.verificarSeguranca();
            alertaVolatilidade.verificarVolatilidade(2900.0);

        } catch (Exception e) {
            System.out.println("Erro ao criar os objetos: " + e.getMessage());
        }
    }
}