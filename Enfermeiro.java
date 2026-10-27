// Declara a classe Enfermeiro.
// Ela herda de Funcionario, entao tambem possui os dados de Pessoa e Funcionario.
public class Enfermeiro extends Funcionario {

    // Construtor da classe Enfermeiro.
    // Recebe nome, CPF, idade, salario base e carga horaria.
    public Enfermeiro(String nome,
                      String cpf,
                      int idade,
                      double salarioBase,
                      int cargaHoraria)
            // O throws informa que pode acontecer erro se a carga horaria for invalida.
            throws CargaHorariaInvalidaException {

        // Chama o construtor da classe pai Funcionario.
        // O Funcionario fica responsavel por guardar os dados e validar a carga horaria.
        super(nome,
                cpf,
                idade,
                salarioBase,
                cargaHoraria);

    }

    // Sobrescrita do metodo calcularSalario() da classe Funcionario.
    // O enfermeiro precisa implementar esse metodo porque Funcionario e abstrata.
    @Override
    public double calcularSalario() {

        // Para Enfermeiro, o salario final e igual ao salario base.
        return getSalarioBase();

    }

}
