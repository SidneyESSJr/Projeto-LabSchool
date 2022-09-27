package controller;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

import entities.Pedagogo;
import interfaces.IntegranteEscola;

public class PedagogoController implements IntegranteEscola<Pedagogo> {

    private Set<Pedagogo> pedagogos = new HashSet<>();

    public static final Scanner scan = new Scanner(System.in);

    public void cadastrar() {
        Pedagogo pedagogo = null;

        System.out.println("\n --- Cadastro de Pedagogo --- ");

        try {
            System.out.print("\nNome: ");
            String nome = scan.nextLine();
            System.out.print("Telefone: ");
            String telefone = scan.next();
            System.out.print("Data de nascimento: ");
            String nascimento = scan.next();
            System.out.print("CPF: ");
            String cpf = scan.next();

            pedagogo = new Pedagogo(nome, cpf, nascimento, telefone);

            pedagogos.add(pedagogo);

            System.out.println("\nPedagogo cadastrado!");

        } catch (Exception e) {
            System.out.println("\nValor invalido!");
        }
    }

    public Pedagogo buscarPorCPF() {
        Pedagogo Pedagogo = null;
        System.out.println("\n --- Buscar Pedagogo --- ");
        try {

            System.out.print("\nCPF: ");
            String cpf = scan.next();

            Pedagogo = pedagogos.stream().filter(p -> p.getDocumento().equalsIgnoreCase(cpf)).findFirst().orElseThrow();

            System.out.println("\nPedagogo localizado!");

        } catch (NoSuchElementException e) {
            System.out.println("\nValor não localizado");
        }
        return Pedagogo;
    }

    public void alterarDados() {
        System.out.println("\n --- Alterar Dados Pedagogo--- ");

        Pedagogo pedagogo = buscarPorCPF();

        if (pedagogo != null) {

            try {
                System.out.print("\nNome: ");
                String nome = scan.next();
                System.out.print("Telefone: ");
                String telefone = scan.next();
                System.out.print("Data de nascimento: ");
                String nascimento = scan.next();

                pedagogos.forEach(p -> {
                    if (p.getDocumento().equalsIgnoreCase(pedagogo.getDocumento())) {
                        p.setNome(nome);
                        p.setTelefone(telefone);
                        p.setDataNascimento(nascimento);
                    }
                });
                System.out.println("\nPedagogo alterado!");

            } catch (InputMismatchException e) {
                System.out.println("\nValor invalido!");
            }

        }
    }

    public Set<Pedagogo> listar() {
        System.out.println("\n --- Lista de Pedagogos --- ");

        if (!pedagogos.isEmpty()) {
            pedagogos.forEach(System.out::println);
        } else {
            System.out.println("\nNenhum Pedagogo cadastrado!");
        }
        return pedagogos;
    }
}
