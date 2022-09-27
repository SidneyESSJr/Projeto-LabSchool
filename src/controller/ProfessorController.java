package controller;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import entities.Professor;
import enums.EnumExperienciaDesenvolvimento;
import enums.EnumFormacaoAcademica;
import interfaces.IntegranteEscola;

public class ProfessorController implements IntegranteEscola<Professor> {

    private Set<Professor> professores = new HashSet<>();

    public static final Scanner scan = new Scanner(System.in);

    public void cadastrar() {
        Professor professor = null;

        System.out.println("\n --- Cadastro de Professor --- ");
        try {

            System.out.print("\nNome: ");
            String nome = scan.nextLine();
            System.out.print("Telefone: ");
            String telefone = scan.next();
            System.out.print("Data de nascimento: ");
            String nascimento = scan.next();
            System.out.print("CPF: ");
            String cpf = scan.next();
            System.out.println("\nFormação academica: ");
            System.out.print("""
                    GRADUACAO_INCOMPLETA(1),
                    GRADUACAO_COMPLETA(2),
                    MESTRADO(3),
                    DOUTORADO(4)
                    Opção: """);
            Integer formacao = scan.nextInt();
            System.out.println("\nExperiencia com desenvolvimento: ");
            System.out.print("""
                    FRONT_END(1),
                    BACK_END(2),
                    FULL_STACK(3);
                    Opção: """);
            Integer experiencia = scan.nextInt();

            professor = new Professor(nome, cpf, nascimento, telefone, EnumFormacaoAcademica.getValor(formacao),
                    EnumExperienciaDesenvolvimento.getValor(experiencia));

            professores.add(professor);

            System.out.println("\nProfessor cadastrado!");

        } catch (InputMismatchException e) {
            System.out.println("\nValor invalido!");
        }
    }

    public Professor buscarPorCPF() {
        Professor Professor = null;
        System.out.println("\n --- Buscar Professor --- ");
        try {

            System.out.print("\nCPF: ");
            String cpf = scan.next();

            Professor = professores.stream().filter(p -> p.getDocumento().equalsIgnoreCase(cpf)).findFirst()
                    .orElseThrow();

            System.out.println("\nProfessor localizado!");

        } catch (NoSuchElementException e) {
            System.out.println("\nValor não localizado");
        }
        return Professor;
    }

    public void alterarDados() {
        System.out.println("\n --- Alterar Dados Professor--- ");

        Professor professor = buscarPorCPF();

        if (professor != null) {

            try {
                System.out.print("\nNome: ");
                String nome = scan.next();
                System.out.print("Telefone: ");
                String telefone = scan.next();
                System.out.print("Data de nascimento: ");
                String nascimento = scan.next();
                System.out.println("\nFormação academica: ");
                System.out.print("""
                        GRADUACAO_INCOMPLETA(1),
                        GRADUACAO_COMPLETA(2),
                        MESTRADO(3),
                        DOUTORADO(4)
                        Opção: """);
                Integer formacao = scan.nextInt();
                System.out.println("\nExperiencia com desenvolvimento: ");
                System.out.print("""
                        FRONT_END(1),
                        BACK_END(2),
                        FULL_STACK(3);
                        Opção: """);
                Integer experiencia = scan.nextInt();

                professores.forEach(p -> {
                    if (p.getDocumento().equalsIgnoreCase(professor.getDocumento())) {
                        p.setNome(nome);
                        p.setTelefone(telefone);
                        p.setDataNascimento(nascimento);
                        p.setExperienciaDesenvolvimento(EnumExperienciaDesenvolvimento.getValor(experiencia));
                        p.setFormacaoAcademica(EnumFormacaoAcademica.getValor(formacao));
                    }
                });
                System.out.println("\nProfessor alterado!");

            } catch (InputMismatchException e) {
                System.out.println("\nValor invalido!");
            }

        }
    }

    public void relatorio(EnumExperienciaDesenvolvimento experiencia) {
        professores.stream().filter(a -> a.getExperienciaDesenvolvimento().equals(experiencia))
                .collect(Collectors.toList())
                .forEach(a -> {
                    System.out.println(
                            "\nCodigo: " + a.getId() + "\nNome: " + a.getNome() + "\nCPF: " + a.getDocumento());
                });
        ;
    }

    public Set<Professor> listar() {
        System.out.println("\n --- Lista de Professors --- ");

        if (!professores.isEmpty()) {
            professores.forEach(p -> {
                System.out.println(
                    "\nCodigo: " + p.getId() + "\nNome: " + p.getNome() + "\nCPF: " + p.getDocumento());
            });
        } else {
            System.out.println("\nNenhum Professor cadastrado!");
        }
        return professores;
    }
}
