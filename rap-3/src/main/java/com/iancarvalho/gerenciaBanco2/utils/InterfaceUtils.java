package com.iancarvalho.gerenciaBanco2.utils;

/**
 *
 * @author ianca
 */
public class InterfaceUtils {

    public static void imprimeCabecalho(String cabecalho) {
        System.out.println("#".repeat(100));
        System.out.println("*".repeat(100));
        System.out.println("#".repeat(30) + "    "+cabecalho+"    " + "#".repeat(30));
        System.out.println("*".repeat(100));
        System.out.println("#".repeat(100));
    }
}
