/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pessoa;

/**
 *
 * @author faust
 */
public class enfermeiro extends funcionario {

    public enfermeiro(String nome, String cpf, int idade,
                      double salarioBase, int cargaHoraria) {

        super(nome, cpf, idade, salarioBase, cargaHoraria);
    }

    @Override
    public double calcularSalario() {
        return salarioBase;
    }
}