import java.util.List;

// Classe Professor
// Herda da classe Usuario e implementa a interface Autenticavel.

public class Professor extends Usuario implements Autenticavel {

    // Area de atuacao do professor
    private String disciplina;
    private String senha;

    // Construtor
    public Professor(String nome, String cpf, String matricula, String disciplina, String senha) {
        super(nome, cpf, matricula);
        this.disciplina = disciplina;
        this.senha = senha;
    }

    // Get
    public String getDisciplina() {
        return disciplina;
    }

    // Set
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    // Sobrescrita do método gerarRelatorio
    @Override
    public void gerarRelatorio() {

        System.out.println("===== RELATÓRIO DO PROFESSOR =====");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Disciplina: " + disciplina);

    }

    // Sobrecarga do método gerarRelatorio
    @Override
    public void gerarRelatorio(boolean completo) {

        if (completo) {

            System.out.println("===== RELATÓRIO COMPLETO DOS ALUNOS =====");
            System.out.println("Professor: " + nome);
            System.out.println("Disciplina: " + disciplina);
            System.out.println("Aqui serão exibidos todos os alunos cadastrados.");

        } else {

            System.out.println("===== RELATÓRIO SIMPLES DOS ALUNOS =====");
            System.out.println("Professor: " + nome);

        }

    }

    // Sobrecarga: relatório dos alunos que estão armazenados no sistema.
    public void gerarRelatorio(List<Usuario> usuarios, boolean completo) {
        System.out.println(completo ? "===== RELATÓRIO COMPLETO DOS ALUNOS ====="
                : "===== RELATÓRIO SIMPLES DOS ALUNOS =====");
        System.out.println("Professor: " + nome);
        System.out.println("Disciplina: " + disciplina);
        boolean possuiAlunos = false;
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Aluno) {
                Aluno aluno = (Aluno) usuario;
                possuiAlunos = true;
                System.out.println("Nome: " + aluno.getNome() + (completo
                        ? " | CPF: " + aluno.getCpf() + " | Matrícula: " + aluno.getMatricula()
                        + " | Curso: " + aluno.getCurso() + " | Período: " + aluno.getPeriodo() : ""));
            }
        }
        if (!possuiAlunos) System.out.println("Nenhum aluno cadastrado.");
    }

    // Implementação do método login
    @Override
    public void login(String usuario, String senha) throws LoginInvalidoException {

        if ((!usuario.equals(nome) && !usuario.equals(matricula)) || !this.senha.equals(senha)) {
            throw new LoginInvalidoException("Usuário ou senha inválidos.");
        }

        System.out.println("Login realizado com sucesso.");

    }

    // Implementação do método logout
    @Override
    public void logout() {

        System.out.println("Logout realizado com sucesso.");

    }

}
