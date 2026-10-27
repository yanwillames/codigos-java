import java.util.ArrayList;
import java.util.Scanner;

public class Principal {

    // Lista que armazenará todos os usuários do sistema
    static ArrayList<Usuario> usuarios = new ArrayList<>();

    // Scanner para leitura dos dados
    static Scanner entrada = new Scanner(System.in);

    // Método para validar a matrícula
    public static void validarMatricula(String matricula) throws MatriculaInvalidaException {

        if (matricula == null || matricula.trim().isEmpty()) {
            throw new MatriculaInvalidaException("Matrícula inválida!");
        }

    }

    public static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);

            if (!entrada.hasNextLine()) {
                System.out.println();
                return 0;
            }

            String valor = entrada.nextLine().trim();

            try {
                return Integer.parseInt(valor);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Digite um numero.");
            }
        }
    }

    // Método para cadastrar um aluno
    public static void cadastrarAluno() {

        try {

            System.out.print("Nome: ");
            String nome = entrada.nextLine();

            System.out.print("CPF: ");
            String cpf = entrada.nextLine();

            System.out.print("Matrícula: ");
            String matricula = entrada.nextLine();

            validarMatricula(matricula);

            System.out.print("Curso: ");
            String curso = entrada.nextLine();

            int periodo = lerInteiro("Período: ");

            usuarios.add(new Aluno(nome, cpf, matricula, curso, periodo));

            System.out.println("\nAluno cadastrado com sucesso!\n");

        } catch (MatriculaInvalidaException e) {

            System.out.println(e.getMessage());

        }

    }

    // Método para cadastrar professor
    public static void cadastrarProfessor() {

        try {

            System.out.print("Nome: ");
            String nome = entrada.nextLine();

            System.out.print("CPF: ");
            String cpf = entrada.nextLine();

            System.out.print("Matrícula: ");
            String matricula = entrada.nextLine();

            validarMatricula(matricula);

            System.out.print("Disciplina: ");
            String disciplina = entrada.nextLine();

            System.out.print("Senha: ");
            String senha = entrada.nextLine();

            usuarios.add(new Professor(nome, cpf, matricula, disciplina, senha));

            System.out.println("\nProfessor cadastrado com sucesso!\n");

        } catch (MatriculaInvalidaException e) {

            System.out.println(e.getMessage());

        }

    }

    // Método para cadastrar coordenador
    public static void cadastrarCoordenador() {

        try {

            System.out.print("Nome: ");
            String nome = entrada.nextLine();

            System.out.print("CPF: ");
            String cpf = entrada.nextLine();

            System.out.print("Matrícula: ");
            String matricula = entrada.nextLine();

            validarMatricula(matricula);

            System.out.print("Curso: ");
            String curso = entrada.nextLine();

            System.out.print("Senha: ");
            String senha = entrada.nextLine();

            usuarios.add(new Coordenador(nome, cpf, matricula, curso, senha));

            System.out.println("\nCoordenador cadastrado com sucesso!\n");

        } catch (MatriculaInvalidaException e) {

            System.out.println(e.getMessage());

        }

    }

    // Método para listar todos os usuários
    public static void listarUsuarios() {

        if (usuarios.isEmpty()) {

            System.out.println("\nNenhum usuário cadastrado.\n");
            return;

        }

        System.out.println("\n===== USUARIOS CADASTRADOS =====\n");

        for (Usuario usuario : usuarios) {

            usuario.gerarRelatorio();
            System.out.println();

        }

    }

        // Método para realizar login
    public static void realizarLogin() {
        System.out.println("Informe seu nome de usuário ou matrícula cadastrada.");

        System.out.print("Usuário: ");
        String usuario = entrada.nextLine();

        System.out.print("Senha: ");
        String senha = entrada.nextLine();

        boolean encontrou = false;

        for (Usuario u : usuarios) {

            if (u instanceof Autenticavel
                    && (u.getNome().equals(usuario) || u.getMatricula().equals(usuario))) {

                try {

                    ((Autenticavel) u).login(usuario, senha);

                    encontrou = true;

                    if (u instanceof Professor) {

                        System.out.println("\n1 - Relatório Simples");
                        System.out.println("2 - Relatório Completo");

                        int opcao = lerInteiro("Escolha: ");

                        ((Professor) u).gerarRelatorio(usuarios, opcao == 2);

                    } else if (u instanceof Coordenador) {

                        System.out.println("\n1 - Relatório Simples");
                        System.out.println("2 - Relatório Completo");

                        int opcao = lerInteiro("Escolha: ");

                        ((Coordenador) u).gerarRelatorio(usuarios, opcao == 2);

                    }

                    ((Autenticavel) u).logout();
                    break;

                } catch (LoginInvalidoException e) {

                    System.out.println("Login inválido: " + e.getMessage());

                    // Continua procurando outro usuário

                }

            }

        }

        if (!encontrou) {
            System.out.println("Login inválido.");
        }

    }

    public static void main(String[] args) {

        int opcao;

        do {

            System.out.println("\n========== SISTEMA ACADÊMICO ==========");
            System.out.println("1 - Cadastrar Aluno");
            System.out.println("2 - Cadastrar Professor");
            System.out.println("3 - Cadastrar Coordenador");
            System.out.println("4 - Listar Usuários");
            System.out.println("5 - Login");
            System.out.println("0 - Sair");

            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {

                case 1:
                    cadastrarAluno();
                    break;

                case 2:
                    cadastrarProfessor();
                    break;

                case 3:
                    cadastrarCoordenador();
                    break;

                case 4:
                    listarUsuarios();
                    break;

                case 5:
                    realizarLogin();
                    break;

                case 0:
                    System.out.println("\nPrograma encerrado.");
                    break;

                default:
                    System.out.println("\nOpção inválida.");

            }

        } while (opcao != 0);

        entrada.close();

    }

}
