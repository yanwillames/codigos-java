// Declara a classe Medico.
// Ela herda de Funcionario e implementa a interface Plantonista.
public class Medico extends Funcionario implements Plantonista {

    // Guarda a quantidade de plantoes extras feitos pelo medico.
    private int plantoesExtras;

    // Construtor da classe Medico.
    // Recebe dados pessoais, dados de funcionario e dados especificos do medico.
    public Medico(String nome, String cpf, int idade,
                  double salarioBase, int cargaHoraria,
                  int plantoesExtras)
            // O throws informa que a carga horaria pode gerar uma excecao.
            throws CargaHorariaInvalidaException {

        // Chama o construtor da classe pai Funcionario.
        // Esse super envia nome, cpf, idade, salarioBase e cargaHoraria para a classe pai.
        super(nome, cpf, idade,
                salarioBase, cargaHoraria);

        // Guarda a quantidade de plantoes extras no atributo da classe.
        this.plantoesExtras = plantoesExtras;
    }

    // Sobrescrita do metodo calcularSalario() da classe Funcionario.
    // O @Override mostra que este metodo esta substituindo o metodo da classe pai.
    @Override
    public double calcularSalario() {

        // Chama a versao sobrecarregada do metodo calcularSalario.
        // Usa automaticamente a quantidade de plantoes extras do proprio objeto.
        return calcularSalario(plantoesExtras);

    }

    // Sobrecarga do metodo calcularSalario.
    // Esta versao recebe a quantidade de plantoes como parametro.
    public double calcularSalario(int plantoes) {

        // Calcula o salario final somando salario base com o valor dos plantoes.
        return getSalarioBase()
                // Multiplica os plantoes por 12 porque cada plantao foi considerado como 12 horas.
                // Depois calcula o valor total dessas horas de plantao.
                + calcularValorPlantao(plantoes * 12);

    }

    // Metodo vindo da interface Plantonista.
    // Como Medico implementa Plantonista, ele precisa ter este metodo.
    @Override
    public double calcularValorPlantao(int horas) {

        // Cada hora de plantao vale 100 reais.
        // Por isso, o valor do plantao e horas multiplicado por 100.
        return horas * 100;

    }

    // Metodo getPlantoesExtras.
    // Serve para consultar a quantidade de plantoes extras do medico.
    public int getPlantoesExtras() {

        // Retorna o valor guardado no atributo plantoesExtras.
        return plantoesExtras;
    }

    // Metodo setPlantoesExtras.
    // Serve para alterar a quantidade de plantoes extras do medico.
    public void setPlantoesExtras(int plantoesExtras) {

        // Atualiza o atributo plantoesExtras com o novo valor recebido.
        this.plantoesExtras = plantoesExtras;
    }

}
