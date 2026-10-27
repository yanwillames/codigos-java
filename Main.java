// Importa a classe ArrayList.
// Ela sera usada para armazenar varios funcionarios em uma lista.
import java.util.ArrayList;

// Importa a classe Scanner.
// Ela sera usada para ler os dados digitados pelo usuario no teclado.
import java.util.Scanner;

// Declara a classe Main.
// Esta e a classe principal do programa, onde fica o menu do sistema.
public class Main {

    // Cria um objeto Scanner para entrada de dados.
    // O System.in indica que os dados virao do teclado.
    static Scanner scanner = new Scanner(System.in);

    // Cria um ArrayList de Funcionario.
    // Como Medico e Enfermeiro herdam de Funcionario, os dois podem entrar nessa lista.
    static ArrayList<Funcionario> funcionarios = new ArrayList<>();

    // Metodo principal do Java.
    // A execucao do programa sempre comeca pelo main.
    public static void main(String[] args) {

        // Variavel que guarda a opcao escolhida pelo usuario no menu.
        int opcao;

        // Estrutura do-while.
        // Ela executa o menu pelo menos uma vez e repete enquanto a opcao for diferente de 0.
        do {

            // Exibe o titulo do sistema.
            System.out.println("\n===== SISTEMA HOSPITALAR =====");

            // Exibe a opcao para cadastrar funcionario.
            System.out.println("1 - Cadastrar Funcionário");

            // Exibe a opcao para remover funcionario.
            System.out.println("2 - Remover Funcionário");

            // Exibe a opcao para alterar funcionario.
            System.out.println("3 - Alterar Funcionário");

            // Exibe a opcao para gerar o relatorio.
            System.out.println("4 - Exibir Relatório");

            // Exibe a opcao para encerrar o programa.
            System.out.println("0 - Sair");

            // Pede que o usuario digite uma opcao.
            System.out.print("Opção: ");

            // Le o numero digitado pelo usuario.
            opcao = scanner.nextInt();

            // Consome a quebra de linha que fica pendente depois do nextInt().
            // Isso evita erro quando o programa usar nextLine() depois.
            scanner.nextLine();

            // O switch escolhe qual acao executar de acordo com a opcao digitada.
            switch (opcao) {

                // Se a opcao for 1, chama o metodo cadastrar().
                case 1:
                    cadastrar();
                    break;

                // Se a opcao for 2, chama o metodo remover().
                case 2:
                    remover();
                    break;

                // Se a opcao for 3, chama o metodo alterar().
                case 3:
                    alterar();
                    break;

                // Se a opcao for 4, chama o metodo relatorio().
                case 4:
                    relatorio();
                    break;

                // Se a opcao for 0, mostra uma mensagem de encerramento.
                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                // Se a opcao nao for nenhuma das anteriores, mostra erro.
                default:
                    System.out.println("Opção inválida.");
            }

        // Enquanto a opcao for diferente de 0, o menu continua aparecendo.
        } while (opcao != 0);

    }

    // =========================
    // CADASTRAR
    // =========================
    // Metodo responsavel por cadastrar um novo funcionario.
    public static void cadastrar() {

        // Mostra a opcao para cadastrar um medico.
        System.out.println("\n1 - Médico");

        // Mostra a opcao para cadastrar um enfermeiro.
        System.out.println("2 - Enfermeiro");

        // Pede que o usuario escolha o tipo de funcionario.
        System.out.print("Escolha: ");

        // Le o tipo escolhido.
        int tipo = scanner.nextInt();

        // Consome a quebra de linha deixada pelo nextInt().
        scanner.nextLine();

        // Pede o nome do funcionario.
        System.out.print("Nome: ");

        // Le o nome completo digitado.
        String nome = scanner.nextLine();

        // Pede o CPF do funcionario.
        System.out.print("CPF: ");

        // Le o CPF digitado.
        String cpf = scanner.nextLine();

        // Pede a idade do funcionario.
        System.out.print("Idade: ");

        // Le a idade digitada.
        int idade = scanner.nextInt();

        // Pede o salario base do funcionario.
        System.out.print("Salário Base: ");

        // Le o salario base digitado.
        double salario = scanner.nextDouble();

        // Pede a carga horaria semanal do funcionario.
        System.out.print("Carga Horária: ");

        // Le a carga horaria digitada.
        int carga = scanner.nextInt();

        // O bloco try tenta criar e cadastrar o funcionario.
        // Ele e necessario porque a carga horaria pode gerar excecao.
        try {

            // Verifica se o tipo escolhido foi 1.
            // Nesse caso, o funcionario sera um medico.
            if (tipo == 1) {

                // Pede a quantidade de plantoes extras do medico.
                System.out.print("Plantões Extras: ");

                // Le a quantidade de plantoes extras.
                int plantoes = scanner.nextInt();

                // Cria um objeto Medico com os dados informados pelo usuario.
                Medico medico = new Medico(
                        nome,
                        cpf,
                        idade,
                        salario,
                        carga,
                        plantoes
                );

                // Adiciona o medico na lista de funcionarios.
                // Isso funciona por polimorfismo, pois Medico e um Funcionario.
                funcionarios.add(medico);

            // Se o tipo nao for 1, o sistema cria um enfermeiro.
            } else {

                // Cria um objeto Enfermeiro com os dados informados pelo usuario.
                Enfermeiro enfermeiro = new Enfermeiro(
                        nome,
                        cpf,
                        idade,
                        salario,
                        carga
                );

                // Adiciona o enfermeiro na lista de funcionarios.
                // Isso funciona por polimorfismo, pois Enfermeiro e um Funcionario.
                funcionarios.add(enfermeiro);

            }

            // Mostra uma mensagem confirmando que o cadastro deu certo.
            System.out.println("Funcionário cadastrado.");

        // O catch captura a excecao se a carga horaria for maior que 60 horas.
        } catch (CargaHorariaInvalidaException e) {

            // Mostra a mensagem de erro definida dentro da excecao.
            System.out.println(e.getMessage());

        }

    }

    // =========================
    // REMOVER
    // =========================
    // Metodo responsavel por remover um funcionario da lista usando o CPF.
    public static void remover() {

        // Pede o CPF do funcionario que o usuario deseja remover.
        System.out.print("CPF do funcionário: ");

        // Le o CPF digitado.
        String cpf = scanner.nextLine();

        // Variavel que vai guardar o funcionario encontrado.
        // Ela comeca com null porque nenhum funcionario foi encontrado ainda.
        Funcionario encontrado = null;

        // Percorre todos os funcionarios cadastrados na lista.
        for (Funcionario f : funcionarios) {

            // Compara o CPF do funcionario atual com o CPF digitado.
            if (f.getCpf().equals(cpf)) {

                // Se os CPFs forem iguais, guarda o funcionario encontrado.
                encontrado = f;

            }

        }

        // Verifica se algum funcionario foi encontrado.
        if (encontrado != null) {

            // Remove da lista o funcionario encontrado.
            funcionarios.remove(encontrado);

            // Mostra mensagem confirmando a remocao.
            System.out.println("Funcionário removido.");

        // Se encontrado continuou null, significa que nenhum CPF bateu.
        } else {

            // Mostra mensagem avisando que nao encontrou o funcionario.
            System.out.println("Funcionário não encontrado.");

        }

    }

    // =========================
    // ALTERAR
    // =========================
    // Metodo responsavel por alterar os dados de um funcionario ja cadastrado.
    public static void alterar() {

        // Pede o CPF do funcionario que sera alterado.
        System.out.print("CPF do funcionário: ");

        // Le o CPF digitado.
        String cpf = scanner.nextLine();

        // Variavel que vai guardar o funcionario encontrado na busca.
        Funcionario encontrado = null;

        // Percorre a lista de funcionarios procurando pelo CPF.
        for (Funcionario f : funcionarios) {

            // Compara o CPF do funcionario atual com o CPF informado pelo usuario.
            if (f.getCpf().equals(cpf)) {

                // Se encontrou o CPF, guarda o funcionario nessa variavel.
                encontrado = f;

            }

        }

        // Verifica se nenhum funcionario foi encontrado.
        if (encontrado == null) {

            // Mostra mensagem informando que o CPF nao existe na lista.
            System.out.println("Funcionário não encontrado.");

            // Encerra o metodo para nao tentar alterar um funcionario inexistente.
            return;

        }

        // Pede o novo nome do funcionario.
        System.out.print("Novo Nome: ");

        // Atualiza o nome usando o metodo setNome(), herdado de Pessoa.
        encontrado.setNome(scanner.nextLine());

        // Pede a nova idade.
        System.out.print("Nova Idade: ");

        // Atualiza a idade usando o metodo setIdade(), herdado de Pessoa.
        encontrado.setIdade(scanner.nextInt());

        // Pede o novo salario base.
        System.out.print("Novo Salário: ");

        // Atualiza o salario base usando o metodo setSalarioBase().
        encontrado.setSalarioBase(scanner.nextDouble());

        // Pede a nova carga horaria.
        System.out.print("Nova Carga Horária: ");

        // Le a nova carga horaria digitada.
        int carga = scanner.nextInt();

        // Tenta atualizar a carga horaria.
        // O try e necessario porque setCargaHoraria pode lancar excecao.
        try {

            // Atualiza a carga horaria, passando antes pela validacao.
            encontrado.setCargaHoraria(carga);

        // Captura a excecao se a carga horaria for invalida.
        } catch (CargaHorariaInvalidaException e) {

            // Mostra a mensagem de erro para o usuario.
            System.out.println(e.getMessage());

        }

        // Verifica se o funcionario encontrado e um objeto da classe Medico.
        // Apenas medico possui o atributo plantoesExtras.
        if (encontrado instanceof Medico) {

            // Pede a nova quantidade de plantoes.
            System.out.print("Novos Plantões: ");

            // Le a quantidade digitada.
            int p = scanner.nextInt();

            // Faz o cast de Funcionario para Medico.
            // Isso permite acessar o metodo setPlantoesExtras().
            ((Medico) encontrado).setPlantoesExtras(p);

        }

        // Consome a quebra de linha que fica pendente depois do nextInt().
        scanner.nextLine();

        // Mostra mensagem confirmando a alteracao.
        System.out.println("Funcionário alterado.");

    }

    // =========================
    // RELATÓRIO
    // =========================
    // Metodo responsavel por exibir os dados de todos os funcionarios.
    public static void relatorio() {

        // Verifica se a lista esta vazia.
        if (funcionarios.isEmpty()) {

            // Mostra mensagem caso nao exista funcionario cadastrado.
            System.out.println("Nenhum funcionário cadastrado.");

            // Encerra o metodo porque nao ha dados para exibir.
            return;

        }

        // Mostra o titulo do relatorio.
        System.out.println("\n===== RELATÓRIO =====");

        // POLIMORFISMO
        // A lista e de Funcionario, mas pode conter objetos Medico e Enfermeiro.
        for (Funcionario f : funcionarios) {

            // Chama o metodo exibirDados() para cada funcionario.
            // Dentro dele, calcularSalario() sera executado de acordo com a classe real do objeto.
            f.exibirDados();

        }

    }

}
