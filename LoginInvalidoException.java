// Exceção personalizada para login inválido

public class LoginInvalidoException extends Exception {

    // Construtor da exceção
    public LoginInvalidoException(String mensagem) {
        super(mensagem);
    }

}