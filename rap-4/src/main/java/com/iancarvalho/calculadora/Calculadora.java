package com.iancarvalho.calculadora;

import com.iancarvalho.calculadora.utils.InterfaceUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ianca
 */
public class Calculadora {

    public static void main(String[] args) {
        try {
            InterfaceUtils.imprimeCabecalho("Calculadora");
            pedeDadosUsuario();
            exibeMenuPrincipal();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public static void pedeDadosUsuario() {
        Scanner scanner = new Scanner(System.in);
        String nome;
        boolean nomeInvalido;
        do {
            System.out.print("Digite seu nome: ");
            nome = scanner.nextLine();
            nomeInvalido = nome.length() < 3;
            if (nomeInvalido) {
                System.out.println("Nome invalido! Precisa de pelo menos 3 caracteres!");
            }
        } while (nomeInvalido);
        System.out.println("Seja bem-vindo(a), " + nome);

    }

    public static void exibeMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        String opcao;
        boolean opcaoInvalida;
        List<String> opcoesValidas = new ArrayList<>();
        opcoesValidas.add("a");
        opcoesValidas.add("b");
        opcoesValidas.add("c");
        opcoesValidas.add("d");
        opcoesValidas.add("e");
        opcoesValidas.add("x");
        do {
            System.out.println("a) Soma");
            System.out.println("b) Subtracao");
            System.out.println("c) Multiplicacao");
            System.out.println("d) Divisao");
            System.out.println("e) Radiciacao");
            System.out.println("x) Sair do programa");
            System.out.print("Digite a opcao desejada: ");
            opcao = scanner.nextLine();
            opcaoInvalida = !opcoesValidas.contains(opcao);
            if (opcaoInvalida) {
                System.out.println("Opcao invalida! Verifique o menu!");
            }
        } while (opcaoInvalida);
        switch (opcao) {
            case "a" ->
                relizarOperacaoDoisFatores("soma");
            case "b" ->
                relizarOperacaoDoisFatores("subtracao");
            case "c" ->
                relizarOperacaoDoisFatores("multiplicacao");
            case "d" ->
                relizarOperacaoDoisFatores("divisao");
            case "e" ->
                realizarRadiciacao();
            case "x" ->
                sair();

        }

    }

    public static void relizarOperacaoDoisFatores(String operacao) {
        Scanner scanner = new Scanner(System.in);
        InterfaceUtils.imprimeCabecalho(operacao.toUpperCase() + " de dois numeros");
        System.out.println("(Dica: utilize virgulas para separar decimais)");
        double valor1 = 0;
        double valor2 = 0;
        double resultado = 0;
        boolean valorInvalido = true;
        do {
            System.out.print("Digite o valor 1: ");
            try {
                valor1 = scanner.nextDouble();
            } catch (Exception err) {
                System.out.println("Erro na digitacao! Verifique se esta no formato correto (sem separação de milhar e com vírgula para separar os decimais)!");
                scanner.nextLine();
                continue;
            }
            System.out.print("Digite o valor 2: ");
            try {
                valor2 = scanner.nextDouble();
            } catch (Exception err) {
                System.out.println("Erro na digitacao! Verifique se esta no formato correto (sem separação de milhar e com vírgula para separar os decimais)!");
                scanner.nextLine();
                continue;
            }
            valorInvalido = false;
        } while (valorInvalido);

        switch (operacao) {
            case "soma" ->
                resultado = Calculos.soma(valor1, valor2);
            case "subtracao" ->
                resultado = Calculos.subtracao(valor1, valor2);
            case "multiplicacao" ->
                resultado = Calculos.multiplicacao(valor1, valor2);
            case "divisao" ->
                resultado = Calculos.divisao(valor1, valor2);
        }

        System.out.println("O resultado e: " + resultado);
        System.out.println("(Pressione qualquer tecla para voltar para o menu...)");
        scanner.nextLine();
        exibeMenuPrincipal();
    }

    public static void realizarRadiciacao() {
        Scanner scanner = new Scanner(System.in);
        InterfaceUtils.imprimeCabecalho("Radicacao de um numero");
        System.out.println("(Dica: utilize virgulas para separar decimais)");
        double valor1 = 0;
        double resultado = 0;
        boolean valorInvalido = true;
        do {
            System.out.print("Digite o valor: ");
            try {
                valor1 = scanner.nextDouble();
            } catch (Exception err) {
                System.out.println("Erro na digitacao! Verifique se esta no formato correto (sem separação de milhar e com vírgula para separar os decimais)!");
                scanner.nextLine();
                break;
            }
            valorInvalido = false;
        } while (valorInvalido);

        resultado = Calculos.radiciacao(valor1);

        System.out.println("O resultado e: " + resultado);
        System.out.println("(Pressione qualquer tecla para voltar para o menu...)");
        scanner.nextLine();
        exibeMenuPrincipal();
    }

    public static void sair() {
        System.out.println("Obrigado por usar o programa de gerenciamento de conta!");
        System.exit(0);
    }

}
