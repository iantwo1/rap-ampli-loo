/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iancarvalho.gerenciaBanco2.utils;

/**
 *
 * @author ianca
 */
public class FinanceiroUtils {

    public static double calculaJurosCompostos(double principal, double jurosAnual, int quantidadeMeses) {
        return principal * Math.pow(1 + jurosAnual, quantidadeMeses / 12); // Divisão dos meses por 12 por conta do juros ser anual
    }
}
