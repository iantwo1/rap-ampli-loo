package com.iancarvalho.gerenciaBanco2;

import com.iancarvalho.gerenciaBanco2.utils.InterfaceUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ianca
 */
public class GerenciaBanco {

    private static final Pessoa cliente = new Pessoa();
    private static final ContaBancaria conta = new ContaBancaria();

    public static void main(String[] args) {
        try {
            InterfaceUtils.imprimeCabecalho("Sistema de Controle de Banco");
            pedeDadosCliente();
            exibeMenuPrincipal();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }
    }

    public static void pedeDadosCliente() {
        Scanner scanner = new Scanner(System.in);
        String nome;
        boolean nomeInvalido;
        String sobrenome;
        boolean sobrenomeInvalido;
        String cpf;
        boolean cpfInvalido;
        do {
            System.out.print("Digite seu nome: ");
            nome = scanner.nextLine();
            nomeInvalido = nome.length() < 3;
            if (nomeInvalido) {
                System.out.println("Nome invalido! Precisa de pelo menos 3 caracteres!");
            }
        } while (nomeInvalido);
        cliente.setNome(nome);

        do {
            System.out.print("Digite seu sobrenome: ");
            sobrenome = scanner.nextLine();
            sobrenomeInvalido = sobrenome.length() < 3;
            if (sobrenomeInvalido) {
                System.out.println("Sobrenome invalido! Precisa de pelo menos 3 caracteres!");
            }
        } while (sobrenomeInvalido);

        do {
            System.out.print("Digite seu CPF (somente numeros): ");
            cpf = scanner.nextLine();
            cpfInvalido = cpf.length() != 11;
            if (cpfInvalido) {
                System.out.println("CPF invalido! Precisa de pelo exatamente 11 caracteres!");
            }
        } while (cpfInvalido);

    }

    public static void exibeMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        String opcao;
        boolean opcaoInvalida;
        List<String> opcoesValidas = new ArrayList<>();
        opcoesValidas.add("a");
        opcoesValidas.add("b");
        opcoesValidas.add("x");
        do {
            System.out.println("a) Transacoes Principais");
            System.out.println("b) Investimentos");
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
                exibeMenuTransacoesPrincipais();
            case "b" ->
                exibeMenuInvestimentos();
            case "x" ->
                sair();
            case "d" ->
                sair();

        }

    }

    public static void exibeMenuTransacoesPrincipais() {
        Scanner scanner = new Scanner(System.in);
        String opcao;
        boolean opcaoInvalida;
        List<String> opcoesValidas = new ArrayList<>();
        opcoesValidas.add("a");
        opcoesValidas.add("b");
        opcoesValidas.add("c");
        opcoesValidas.add("d");
        do {
            System.out.println("a) Consultar Saldo");
            System.out.println("b) Realizar deposito");
            if (conta.getSaldo() > 0) {
                System.out.println("c) Realizar retirada");
            }
            System.out.println("d) Sair");
            System.out.print("Digite a opcao desejada: ");
            opcao = scanner.nextLine();
            opcaoInvalida = !opcoesValidas.contains(opcao);
            if (opcaoInvalida) {
                System.out.println("Opcao invalida! Verifique o menu!");
            }
        } while (opcaoInvalida);
        switch (opcao) {
            case "a" ->
                consultarSaldo();
            case "b" ->
                realizarDeposito();
            case "c" ->
                realizarRetirada();
            case "d" ->
                exibeMenuPrincipal();

        }
    }

    public static void exibeMenuInvestimentos() {
        Scanner scanner = new Scanner(System.in);
        String opcao;
        boolean opcaoInvalida;
        List<String> opcoesValidas = new ArrayList<>();
        opcoesValidas.add("a");
        opcoesValidas.add("b");
        opcoesValidas.add("c");
        InterfaceUtils.imprimeCabecalho("Simulador de investimentos");
        do {
            System.out.println("a) CDB (10% ao ano)");
            System.out.println("b) LCI (8% ao ano)");
            System.out.println("c) Sair");
            System.out.print("Digite a opcao desejada: ");
            opcao = scanner.nextLine();
            opcaoInvalida = !opcoesValidas.contains(opcao);
            if (opcaoInvalida) {
                System.out.println("Opcao invalida! Verifique o menu!");
            }
        } while (opcaoInvalida);
        switch (opcao) {
            case "a" ->
                simularCDB();
            case "b" ->
                simularLCI();
            case "c" ->
                exibeMenuPrincipal();

        }

    }

    public static void consultarSaldo() {
        Scanner scanner = new Scanner(System.in);
        InterfaceUtils.imprimeCabecalho("Saldo da Conta de " + cliente.getNome());
        System.out.println("O saldo da conta e ");
        System.out.println("R$ " + conta.getSaldo());
        System.out.println("(Pressione qualquer tecla para voltar para o menu...)");
        scanner.nextLine();
        exibeMenuTransacoesPrincipais();
    }

    public static void realizarDeposito() {
        Scanner scanner = new Scanner(System.in);
        InterfaceUtils.imprimeCabecalho("Deposito na Conta de " + cliente.getNome());
        System.out.println("(Dica: utilize virgulas para separar decimais)");
        double valorDepositar = 0;
        boolean valorInvalido;
        do {
            System.out.print("Digite o valor a ser depositado (Saldo atual: R$ " + conta.getSaldo() + "): ");
            try {
                valorDepositar = scanner.nextDouble();
            } catch (Exception err) {
                System.out.println("Erro na digitacao! Verifique se esta no formato correto (sem separação de milhar e com vírgula para separar os decimais)!");
                scanner.nextLine();
            }
            valorInvalido = valorDepositar <= 0;
            if (valorInvalido) {
                System.out.println("Valor invalido! Precisa ser maior que zero!");
            }
        } while (valorInvalido);

        conta.depositar(valorDepositar);
        System.out.println("Valor de R$ " + valorDepositar + " depositado com sucesso! Novo saldo e de R$ " + conta.getSaldo());
        exibeMenuTransacoesPrincipais();
    }

    public static void realizarRetirada() {
        if (conta.getSaldo() < 0) {
            System.out.println("Não pode ser realizada retirada em conta com saldo zerado!");
            exibeMenuTransacoesPrincipais();
            return;
        }
        Scanner scanner = new Scanner(System.in);
        InterfaceUtils.imprimeCabecalho("Retirada da Conta de " + cliente.getNome());
        System.out.println("(Dica: utilize virgulas para separar decimais)");
        double valorRetirar = 0;
        boolean valorInvalido;
        do {
            System.out.print("Digite o valor a ser retirado (Saldo atual: R$ " + conta.getSaldo() + "): ");
            try {
                valorRetirar = scanner.nextDouble();
            } catch (Exception err) {
                System.out.println("Erro na digitacao! Verifique se esta no formato correto (sem separação de milhar e com vírgula para separar os decimais)!");
                scanner.nextLine();
            }
            valorInvalido = valorRetirar <= 0 || valorRetirar > conta.getSaldo();
            if (valorInvalido) {
                System.out.println("Valor invalido! Precisa ser maior que zero e menor ou igual ao saldo atual!");
            }
        } while (valorInvalido);

        conta.retirar(valorRetirar);
        System.out.println("Valor de R$ " + valorRetirar + " retirado com sucesso! Novo saldo e de R$ " + conta.getSaldo());
        exibeMenuTransacoesPrincipais();
    }

    public static void simularCDB() {
        Scanner scanner = new Scanner(System.in);
        InterfaceUtils.imprimeCabecalho("Simulador de investimento em CDB (10% ao ano)");
        System.out.println("(Dica: utilize virgulas para separar decimais)");
        double valorInvestir = 0;
        int quantidadeMeses = 0;
        boolean valorInvalido;
        do {
            System.out.print("Digite o valor a ser investido: ");
            try {
                valorInvestir = scanner.nextDouble();
            } catch (Exception err) {
                System.out.println("Erro na digitacao! Verifique se esta no formato correto (sem separação de milhar e com vírgula para separar os decimais)!");
                scanner.nextLine();
                break;
            }
            System.out.print("Digite a quantidade de meses: ");
            try {
                quantidadeMeses = scanner.nextInt();
            } catch (Exception err) {
                System.out.println("Erro na digitacao! Verifique se esta no formato correto (valor inteiro sem decimais)!");
                scanner.nextLine();
                break;
            }
            valorInvalido = valorInvestir <= 0 || quantidadeMeses <= 0;
            if (valorInvalido) {
                System.out.println("Valores invalidos! Precisam ser maiores que zero!");
            }
        } while (valorInvalido);

        double valorAcumulado = AplicacaoBancaria.calcularCDB(valorInvestir, quantidadeMeses);
        InterfaceUtils.imprimeLinhaSeparadora();
        InterfaceUtils.imprimeLinhaSeparadora();
        System.out.println("Que otimo! Ja temos um resultado para sua simulação!");
        System.out.println("Valor a investir: R$" + valorInvestir);
        System.out.println("Quantidade de meses: " + quantidadeMeses);
        System.out.println("Juros: 10% ao ano");
        System.out.println("Resultado acumulado: R$" + valorAcumulado);
        InterfaceUtils.imprimeLinhaSeparadora();
        InterfaceUtils.imprimeLinhaSeparadora();
        System.out.println("(Pressione qualquer tecla para voltar para o menu...)");
        scanner.nextLine();
        exibeMenuInvestimentos();
    }

    public static void simularLCI() {
        Scanner scanner = new Scanner(System.in);
        InterfaceUtils.imprimeCabecalho("Simulador de investimento em LCI (8% ao ano)");
        System.out.println("(Dica: utilize virgulas para separar decimais)");
        double valorInvestir = 0;
        int quantidadeMeses = 0;
        boolean valorInvalido;
        do {
            System.out.print("Digite o valor a ser investido: ");
            try {
                valorInvestir = scanner.nextDouble();
            } catch (Exception err) {
                System.out.println("Erro na digitacao! Verifique se esta no formato correto (sem separação de milhar e com vírgula para separar os decimais)!");
                scanner.nextLine();
                break;
            }
            System.out.print("Digite a quantidade de meses: ");
            try {
                quantidadeMeses = scanner.nextInt();
            } catch (Exception err) {
                System.out.println("Erro na digitacao! Verifique se esta no formato correto (valor inteiro sem decimais)!");
                scanner.nextLine();
                break;
            }
            valorInvalido = valorInvestir <= 0 || quantidadeMeses <= 0;
            if (valorInvalido) {
                System.out.println("Valores invalidos! Precisam ser maiores que zero!");
            }
        } while (valorInvalido);

        double valorAcumulado = AplicacaoBancaria.calcularLCI(valorInvestir, quantidadeMeses);
        InterfaceUtils.imprimeLinhaSeparadora();
        InterfaceUtils.imprimeLinhaSeparadora();
        System.out.println("Que otimo! Ja temos um resultado para sua simulação!");
        System.out.println("Valor a investir: R$" + valorInvestir);
        System.out.println("Quantidade de meses: " + quantidadeMeses);
        System.out.println("Juros: 8% ao ano");
        System.out.println("Resultado acumulado: R$" + valorAcumulado);
        InterfaceUtils.imprimeLinhaSeparadora();
        InterfaceUtils.imprimeLinhaSeparadora();
        System.out.println("(Pressione qualquer tecla para voltar para o menu...)");
        scanner.nextLine();
        exibeMenuInvestimentos();
    }

    public static void sair() {
        System.out.println("Obrigado por usar o programa de gerenciamento de conta!");
        System.exit(0);
    }

}
