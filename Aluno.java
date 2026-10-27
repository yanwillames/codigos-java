// Classe Aluno
// Herda da classe abstrata Usuario

public class Aluno extends Usuario {

    // Atributos específicos do aluno
    private String curso;
    private int periodo;

    // Construtor da classe
    // O super() chama o construtor da classe Usuario
    public Aluno(String nome, String cpf, String matricula, String curso, int periodo) {
        super(nome, cpf, matricula);
        this.curso = curso;
        this.periodo = periodo;
    }

    // Método get para retornar o curso
    public String getCurso() {
        return curso;
    }

    // Método set para alterar o curso
    public void setCurso(String curso) {
        this.curso = curso;
    }

    // Método get para retornar o período
    public int getPeriodo() {
        return periodo;
    }

    // Método set para alterar o período
    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    // Sobrescrita do método abstrato gerarRelatorio()
    // Exibe todas as informações do aluno
    @Override
    public void gerarRelatorio() {

        System.out.println("===== RELATÓRIO DO ALUNO =====");
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso);
        System.out.println("Período: " + periodo);

    }

    // Sobrecarga do método gerarRelatorio()
    // Permite gerar um relatório simples ou completo
    @Override
    public void gerarRelatorio(boolean completo) {

        // Se for verdadeiro, mostra todas as informações
        if (completo) {

            System.out.println("===== RELATÓRIO COMPLETO DO ALUNO =====");
            System.out.println("Nome: " + nome);
            System.out.println("CPF: " + cpf);
            System.out.println("Matrícula: " + matricula);
            System.out.println("Curso: " + curso);
            System.out.println("Período: " + periodo);

        } else {

            // Caso contrário, mostra apenas os dados principais
            System.out.println("===== RELATÓRIO SIMPLES DO ALUNO =====");
            System.out.println("Nome: " + nome);
            System.out.println("Curso: " + curso);

        }

    }

}