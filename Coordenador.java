import java.util.List;

// Classe Coordenador
// Herda da classe Usuario e implementa a interface Autenticavel.

public class Coordenador extends Usuario implements Autenticavel {

    // Curso que o coordenador é responsável
    private String curso;
    private String senha;

    // Construtor
    public Coordenador(String nome, String cpf, String matricula, String curso, String senha) {
        super(nome, cpf, matricula);
        this.curso = curso;
        this.senha = senha;
    }

    // Get
    public String getCurso() {
        return curso;
    }

    // Set
    public void setCurso(String curso) {
        this.curso = curso;
    }

    // Sobrescrita do método gerarRelatorio
    @Override
    public void gerarRelatorio() {

        System.out.println("===== RELATÓRIO DO COORDENADOR =====");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso Coordenado: " + curso);

    }

    // Sobrecarga do método gerarRelatorio
    @Override
    public void gerarRelatorio(boolean completo) {

        if (completo) {

            System.out.println("===== RELATÓRIO COMPLETO =====");
            System.out.println("Coordenador: " + nome);
            System.out.println("Curso: " + curso);
            System.out.println("Relatório completo de alunos e professores.");

        } else {

            System.out.println("===== RELATÓRIO SIMPLES =====");
            System.out.println("Coordenador: " + nome);

        }

    }

    // Sobrecarga: relatório dos alunos e professores armazenados no sistema.
    public void gerarRelatorio(List<Usuario> usuarios, boolean completo) {
        System.out.println(completo ? "===== RELATÓRIO COMPLETO DE ALUNOS E PROFESSORES ====="
                : "===== RELATÓRIO SIMPLES DE ALUNOS E PROFESSORES =====");
        System.out.println("Coordenador: " + nome);
        boolean encontrou = false;
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Aluno) {
                Aluno aluno = (Aluno) usuario;
                encontrou = true;
                System.out.println("Aluno: " + aluno.getNome() + (completo
                        ? " | CPF: " + aluno.getCpf() + " | Matrícula: " + aluno.getMatricula()
                        + " | Curso: " + aluno.getCurso() + " | Período: " + aluno.getPeriodo() : ""));
            } else if (usuario instanceof Professor) {
                Professor professor = (Professor) usuario;
                encontrou = true;
                System.out.println("Professor: " + professor.getNome() + (completo
                        ? " | CPF: " + professor.getCpf() + " | Matrícula: " + professor.getMatricula()
                        + " | Disciplina: " + professor.getDisciplina() : ""));
            }
        }
        if (!encontrou) System.out.println("Nenhum aluno ou professor cadastrado.");
    }

    // Implementação do login
    @Override
    public void login(String usuario, String senha) throws LoginInvalidoException {

        if ((!usuario.equals(nome) && !usuario.equals(matricula)) || !this.senha.equals(senha)) {

            throw new LoginInvalidoException("Usuário ou senha inválidos.");

        }

        System.out.println("Login realizado com sucesso.");

    }

    // Implementação do logout
    @Override
    public void logout() {

        System.out.println("Logout realizado com sucesso.");

    }

}
