package com.iancarvalho.gerenciaBanco2;

import com.iancarvalho.gerenciaBanco2.utils.FinanceiroUtils;

/**
 *
 * @author ianca
 */
public class AplicacaoBancaria {

    public static double calcularCDB(double valor, int quantidadeMeses) {
        return FinanceiroUtils.calculaJurosCompostos(valor, 0.10, quantidadeMeses);
    }

    public static double calcularLCI(double valor, int quantidadeMeses) {
        return FinanceiroUtils.calculaJurosCompostos(valor, 0.08, quantidadeMeses);
    }
}
