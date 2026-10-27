/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pessoa;

/**
 *
 * @author faust
 */
import java.util.ArrayList;
import java.util.Scanner;

public class principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<funcionario> funcionarios = new ArrayList<>();

        int opcao;

        do {
            System.out.println("\n===== SISTEMA HOSPITALAR =====");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Remover funcionário");
            System.out.println("3 - Alterar funcionário");
            System.out.println("4 - Exibir relatório");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Idade: ");
                    int idade = sc.nextInt();

                    System.out.print("Salário base: ");
                    double salario = sc.nextDouble();

                    System.out.print("Carga horária semanal: ");
                    int carga = sc.nextInt();

                    System.out.println("1 - Médico");
                    System.out.println("2 - Enfermeiro");
                    System.out.print("Cargo: ");
                    int cargo = sc.nextInt();

                    try {

                        if (cargo == 1) {

                            medico medico = new medico(
                                nome, cpf, idade, salario, carga
                            );

                            medico.validarCargaHoraria();

                            System.out.print("Quantidade de plantões extras: ");
                            int plantoes = sc.nextInt();

                            medico.setPlantoesExtras(plantoes);

                            funcionarios.add(medico);

                        } else if (cargo == 2) {

                            enfermeiro Enfermeiro = new enfermeiro(
                                nome, cpf, idade, salario, carga
                            );

                            enfermeiro.validarCargaHoraria();

                            funcionarios.add(Enfermeiro);
                        }

                        System.out.println("Funcionário cadastrado!");

                    } catch (CargaHorariaInvalidaException e) {

                        System.out.println("Erro: " + e.getMessage());

                    }

                    break;

                case 2:

                    System.out.print("Digite o CPF do funcionário: ");
                    String cpfRemover = sc.nextLine();

                    boolean removido = false;

                    for (int i = 0; i < funcionarios.size(); i++) {

                        if (funcionarios.get(i).cpf.equals(cpfRemover)) {

                            funcionarios.remove(i);
                            removido = true;
                            System.out.println("Funcionário removido!");
                            break;
                        }
                    }

                    if (!removido) {
                        System.out.println("Funcionário não encontrado.");
                    }

                    break;

                case 3:

                    System.out.print("Digite o CPF do funcionário: ");
                    String cpfAlterar = sc.nextLine();

                    boolean encontrado = false;

                    for (funcionario f : Funcionarios) {

                        if (f.cpf.equals(cpfAlterar)) {

                            System.out.print("Novo nome: ");
                            f.nome = sc.nextLine();

                            System.out.print("Nova idade: ");
                            f.idade = sc.nextInt();

                            System.out.print("Nova carga horária: ");
                            f.cargaHoraria = sc.nextInt();

                            try {

                                f.validarCargaHoraria();
                                System.out.println("Dados alterados!");

                            } catch (CargaHorariaInvalidaException e) {

                                System.out.println("Erro: " + e.getMessage());
                            }

                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("Funcionário não encontrado.");
                    }

                    break;

                case 4:

                    System.out.println("\n===== RELATÓRIO =====");

                    if (funcionarios.isEmpty()) {
                        System.out.println("Nenhum funcionário cadastrado.");
                    }

                    for (funcionario f : Funcionarios) {

                        System.out.println("--------------------");
                        System.out.println("Nome: " + f.nome);
                        System.out.println("Cargo: " + f.getCargo());

                        // Polimorfismo
                        System.out.println(
                            "Salário: R$ " + f.calcularSalario()
                        );

                        System.out.println(
                            "Carga Horária: " + f.cargaHoraria + " horas"
                        );
                    }

                    break;

                case 0:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}