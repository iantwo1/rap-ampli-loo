package com.iancarvalho.gerenciaBanco2.utils;

/**
 *
 * @author ianca
 */
public class InterfaceUtils {

    public static void imprimeLinhaSeparadora() {
        System.out.println("#".repeat(100));
    }

    public static void imprimeCabecalho(String cabecalho) {
        imprimeLinhaSeparadora();
        imprimeLinhaSeparadora();
        System.out.println("#".repeat(30) + "    " + cabecalho + "    " + "#".repeat(30));
        imprimeLinhaSeparadora();
        imprimeLinhaSeparadora();
    }
}
