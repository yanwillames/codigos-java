// Exceção personalizada para matrícula inválida

public class MatriculaInvalidaException extends Exception {

    // Construtor da exceção
    public MatriculaInvalidaException(String mensagem) {
        super(mensagem);
    }

}