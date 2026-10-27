/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pessoa;

/**
 *
 * @author faust
 */
public class medico extends funcionario implements plantonista {

    private int plantoesExtras;

    public medico(String nome, String cpf, int idade,
                  double salarioBase, int cargaHoraria) {

        super(nome, cpf, idade, salarioBase, cargaHoraria);
        this.plantoesExtras = 0;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (plantoesExtras * calcularValorPlantao(12));
    }

    // Sobrecarga
    public double calcularSalario(int quantidadePlantoes) {
        return salarioBase +
               (quantidadePlantoes * calcularValorPlantao(12));
    }

    @Override
    public double calcularValorPlantao(int horas) {
        return horas * 100;
    }

    public void setPlantoesExtras(int plantoesExtras) {
        this.plantoesExtras = plantoesExtras;
    }
}