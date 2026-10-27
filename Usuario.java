// Classe abstrata Usuario
// Herda da classe Pessoa.

public abstract class Usuario extends Pessoa {

    // Atributo específico do usuário
    protected String matricula;

    // Construtor
    public Usuario(String nome, String cpf, String matricula) {
        super(nome, cpf);
        this.matricula = matricula;
    }

    // Get e Set
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    // Método abstrato
    public abstract void gerarRelatorio();

    // Sobrecarga do método gerarRelatorio
    public void gerarRelatorio(boolean completo) {

        if (completo) {

            System.out.println("===== RELATÓRIO COMPLETO =====");
            System.out.println("Nome: " + nome);
            System.out.println("CPF: " + cpf);
            System.out.println("Matrícula: " + matricula);

        } else {

            System.out.println("===== RELATÓRIO SIMPLES =====");
            System.out.println("Nome: " + nome);

        }

    }

}