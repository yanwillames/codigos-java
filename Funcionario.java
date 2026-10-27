// Declara uma classe abstrata chamada Funcionario.
// Ela herda da classe Pessoa, entao todo funcionario tambem tem nome, CPF e idade.
public abstract class Funcionario extends Pessoa {

    // Guarda o salario base do funcionario.
    // Esse valor sera usado no calculo do salario final.
    private double salarioBase;

    // Guarda a carga horaria semanal do funcionario.
    private int cargaHoraria;

    // Construtor da classe Funcionario.
    // Recebe os dados herdados de Pessoa e os dados proprios de Funcionario.
    public Funcionario(String nome, String cpf, int idade,
                       double salarioBase, int cargaHoraria)
            // O throws informa que este construtor pode lancar a excecao personalizada.
            throws CargaHorariaInvalidaException {

        // Chama o construtor da classe pai Pessoa.
        // Assim, nome, cpf e idade sao inicializados pela classe Pessoa.
        super(nome, cpf, idade);

        // Chama o metodo que verifica se a carga horaria e valida.
        // Se for maior que 60, o programa lanca uma excecao.
        validarCargaHoraria(cargaHoraria);

        // Guarda o salario base recebido no atributo salarioBase.
        this.salarioBase = salarioBase;

        // Guarda a carga horaria recebida no atributo cargaHoraria.
        this.cargaHoraria = cargaHoraria;
    }

    // Metodo abstrato exigido pela questao.
    // Ele nao tem corpo aqui porque cada classe filha calcula o salario de um jeito.
    public abstract double calcularSalario();

    // Metodo concreto exigido pela questao.
    // Ele ja tem corpo e pode ser usado por Medico e Enfermeiro.
    public void exibirDados() {

        // Imprime uma linha para separar visualmente os dados no relatorio.
        System.out.println("-------------------------");

        // Mostra o nome do funcionario usando o metodo getNome(), herdado de Pessoa.
        System.out.println("Nome: " + getNome());

        // Mostra o cargo usando o nome da classe real do objeto.
        // Se o objeto for Medico, aparece Medico; se for Enfermeiro, aparece Enfermeiro.
        System.out.println("Cargo: " + getClass().getSimpleName());

        // Mostra o salario calculado.
        // Aqui ocorre polimorfismo, pois o metodo chamado depende do tipo real do objeto.
        System.out.println("Salário: R$ " + calcularSalario());

        // Mostra a carga horaria semanal do funcionario.
        System.out.println("Carga Horária: " + cargaHoraria + " horas");
    }

    // Metodo responsavel por validar a carga horaria.
    // O throws indica que a excecao pode ser enviada para quem chamou o metodo.
    public void validarCargaHoraria(int carga)
            throws CargaHorariaInvalidaException {

        // Verifica se a carga horaria passou do limite de 60 horas semanais.
        if (carga > 60) {

            // Lanca uma excecao personalizada quando a carga horaria e invalida.
            throw new CargaHorariaInvalidaException(
                    // Mensagem que explica o motivo do erro.
                    "Carga horária maior que 60 horas."
            );
        }
    }

    // Metodo getSalarioBase.
    // Serve para consultar o salario base do funcionario.
    public double getSalarioBase() {

        // Retorna o valor guardado no atributo salarioBase.
        return salarioBase;
    }

    // Metodo setSalarioBase.
    // Serve para alterar o salario base do funcionario.
    public void setSalarioBase(double salarioBase) {

        // Atualiza o atributo salarioBase com o novo valor recebido.
        this.salarioBase = salarioBase;
    }

    // Metodo getCargaHoraria.
    // Serve para consultar a carga horaria do funcionario.
    public int getCargaHoraria() {

        // Retorna o valor guardado no atributo cargaHoraria.
        return cargaHoraria;
    }

    // Metodo setCargaHoraria.
    // Serve para alterar a carga horaria do funcionario.
    public void setCargaHoraria(int cargaHoraria)
            // O throws e necessario porque a nova carga tambem precisa ser validada.
            throws CargaHorariaInvalidaException {

        // Valida a nova carga horaria antes de guardar.
        validarCargaHoraria(cargaHoraria);

        // Se nao houve excecao, atualiza o atributo cargaHoraria.
        this.cargaHoraria = cargaHoraria;
    }

}

// Interface Plantonista.
// Interface define um contrato que a classe implementadora deve cumprir.
interface Plantonista {

    // Metodo que deve calcular o valor do plantao a partir da quantidade de horas.
    double calcularValorPlantao(int horas);

}

// Excecao personalizada criada para representar erro de carga horaria.
// Ela herda de Exception, entao o Java obriga o tratamento com try-catch ou throws.
class CargaHorariaInvalidaException extends Exception {

    // Construtor da excecao.
    // Recebe uma mensagem explicando o erro.
    public CargaHorariaInvalidaException(String mensagem) {

        // Envia a mensagem para o construtor da classe pai Exception.
        super(mensagem);
    }

}
