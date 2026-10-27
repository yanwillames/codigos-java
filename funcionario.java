/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pessoa;

/**
 *
 * @author faust
 */
public abstract class funcionario extends Pessoa {
    protected double salarioBase;
    protected int cargaHoraria;

    public funcionario(String nome, String cpf, int idade,
                       double salarioBase, int cargaHoraria) {
        super(nome, cpf, idade);
        this.salarioBase = salarioBase;
        this.cargaHoraria = cargaHoraria;
    }

    public abstract double calcularSalario();

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Idade: " + idade);
        System.out.println("Salário: R$ " + calcularSalario());
        System.out.println("Carga Horária: " + cargaHoraria + " horas");
    }

    public void validarCargaHoraria() throws CargaHorariaInvalidaException {
        if (cargaHoraria > 60) {
            throw new CargaHorariaInvalidaException(
                "A carga horária não pode ser maior que 60 horas."
            );
        }
    }

    public String getCargo() {
        return getClass().getSimpleName();
    }
}
