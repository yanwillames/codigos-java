// Interface Autenticavel
// Define os métodos de login e logout.
// Apenas Professor e Coordenador irão implementar esta interface.

public interface Autenticavel {

    // Método para realizar o login
    void login(String usuario, String senha) throws LoginInvalidoException;

    // Método para realizar o logout
    void logout();

}