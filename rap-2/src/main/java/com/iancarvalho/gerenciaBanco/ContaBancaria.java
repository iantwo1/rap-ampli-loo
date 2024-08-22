/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iancarvalho.gerenciaBanco;

/**
 *
 * @author ianca
 */
public class ContaBancaria {

    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            throw new Error("O saldo nao pode ser abaixo de zero!");
        }
        this.saldo = saldo;
    }

    public void depositar(double valor
    ) {
        this.setSaldo(this.saldo + valor);
    }
     public void retirar(double valor
    ) {
        this.setSaldo(this.saldo - valor);
    }

}
