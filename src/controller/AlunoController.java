package controller;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import entities.Aluno;
import enums.EnumMatricula;
import interfaces.IntegranteEscola;

public class AlunoController implements IntegranteEscola<Aluno> {

    private Set<Aluno> alunos = new HashSet<>();

    public static final Scanner scan = new Scanner(System.in);

    @Override
    public void cadastrar() {
        Aluno aluno = null;

        System.out.println("\n --- Cadastro de Aluno --- ");
        try {

            System.out.print("\nNome: ");
            String nome = scan.nextLine();
            System.out.print("Telefone: ");
            String telefone = scan.next();
            System.out.print("Data de nascimento: ");
            String nascimento = scan.next();
            System.out.print("CPF: ");
            String cpf = scan.next();

            aluno = new Aluno(nome, cpf, nascimento, telefone);

            alunos.add(aluno);

            System.out.println("\nAluno cadastrado!");

        } catch (InputMismatchException e) {
            System.out.println("\nValor invalido!");
        }
    }

    @Override
    public Aluno buscarPorCPF() {
        Aluno aluno = null;
        System.out.println("\n --- Buscar Aluno --- ");
        try {

            System.out.print("\nCPF: ");
            String cpf = scan.next();

            aluno = alunos.stream().filter(a -> a.getDocumento().equalsIgnoreCase(cpf)).findFirst().orElseThrow();

            System.out.println("\nAluno localizado!");

        } catch (NoSuchElementException e) {
            System.out.println("\nValor não localizado");
        }
        return aluno;
    }

    @Override
    public void alterarDados() {
        System.out.println("\n --- Alterar Dados Aluno--- ");

        Aluno aluno = buscarPorCPF();

        if (aluno != null) {

            try {
                System.out.print("\nNome: ");
                String nome = scan.next();
                System.out.print("Telefone: ");
                String telefone = scan.next();
                System.out.print("Data de nascimento: ");
                String nascimento = scan.next();
                System.out.println("\nSituação matricula: ");
                System.out.print("""
                        ATIVO(1),
                        IRREGULAR(2),
                        ATENDIMENTO_PEDAGOGICO(3),
                        INATIVO(4)
                        Opção: """);
                Integer matricula = scan.nextInt();

                alunos.forEach(p -> {
                    if (p.getDocumento().equalsIgnoreCase(aluno.getDocumento())) {
                        p.setNome(nome);
                        p.setTelefone(telefone);
                        p.setDataNascimento(nascimento);
                        p.setMatricula(EnumMatricula.getValor(matricula));
                    }
                });
                System.out.println("\nAluno alterado!");

            } catch (InputMismatchException e) {
                System.out.println("\nValor invalido!");
            }

        }
    }

    public void relatorio(EnumMatricula matricula) {
        alunos.stream().filter(a -> a.getMatricula().equals(matricula)).collect(Collectors.toList())
                .forEach(a -> {
                    System.out.println(
                            "\nCodigo: " + a.getId() + "\nNome: " + a.getNome() + "\nCPF: " + a.getDocumento());
                });
        ;
    }

    @Override
    public Set<Aluno> listar() {
        System.out.println("\n --- Lista de Alunos --- ");

        if (!alunos.isEmpty()) {
            alunos.forEach(a -> {
                System.out.println(
                        "\nCodigo: " + a.getId() + "\nNome: " + a.getNome() + "\nCPF: " + a.getDocumento());
            });
        } else {
            System.out.println("\nNenhum aluno cadastrado!");
        }

        return alunos;
    }

}
