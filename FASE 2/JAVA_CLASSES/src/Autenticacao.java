import java.time.LocalDateTime;
import java.util.UUID;

// GI
public class Autenticacao {

    // atributos
    private Usuario usuario;
    private String token;
    private LocalDateTime expiracao;

    // contrutores
    public Autenticacao() {
    }

    public Autenticacao(Usuario usuario, String token, LocalDateTime expiracao) {
        this.usuario = usuario;
        this.token = token;
        this.expiracao = expiracao;
    }

    // métodos
    public void login() {
        if (this.usuario != null) {
            this.token = UUID.randomUUID().toString();         // gera um token aleatório
            this.expiracao = LocalDateTime.now().plusHours(1); // define validade de 1 hora
            System.out.println("Usuário logado com sucesso. Token gerado: " + this.token);
        } else {
            System.out.println("Não foi possível efetuar login: usuário não definido.");
        }
    }

    public void logout() {
        this.token = null;
        this.expiracao = null;
        System.out.println("Usuário deslogado com sucesso.");
    }

    public boolean validarToken() {
        // Verifica se existe token e se não expirou
        if (this.token != null && this.expiracao != null) {
            LocalDateTime agora = LocalDateTime.now();
            if (agora.isBefore(this.expiracao)) {
                System.out.println("Token válido.");
                return true;
            } else {
                System.out.println("Token expirado.");
                return false;
            }
        }
        System.out.println("Token inexistente ou inválido.");
        return false;
    }

    // getters e setters
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getExpiracao() {
        return expiracao;
    }

    public void setExpiracao(LocalDateTime expiracao) {
        this.expiracao = expiracao;
    }
}
