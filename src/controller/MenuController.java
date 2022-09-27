package controller;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Aluno;
import entities.Pedagogo;
import enums.EnumExperienciaDesenvolvimento;
import enums.EnumMatricula;

public class MenuController {

    private AlunoController alunoController;
    private ProfessorController professorController;
    private PedagogoController pedagogoController;
    private AtendimentoPedagogicoController atendimentoPedagogicoController;

    public MenuController() {
        this.alunoController = new AlunoController();
        this.professorController = new ProfessorController();
        this.pedagogoController = new PedagogoController();
    }

    public static final Scanner scan = new Scanner(System.in);

    public Integer MenuPrincipal() {
        System.out.println("\n --- LAB SCHOOL --- ");
        Integer opcao = 0;
        try {

            System.out.println("\n[1]Novo cadastro");
            System.out.println("[2]Alterar dados");
            System.out.println("[3]Atendimento pedagógico");
            System.out.println("[4]Relatórios");
            System.out.println("[0]Sair");
            System.out.print("Opção: ");

            opcao = scan.nextInt();

            if (opcao != 0) {
                seletorDeOpcoesPrincipal(opcao);
            }
        } catch (InputMismatchException e) {
            System.out.println("\nValor invalido!");
        }
        return opcao;

    }

    private void seletorDeOpcoesPrincipal(Integer opcao) {
        switch (opcao) {
            case 1 -> novoCadastro();
            case 2 -> alterarDados();
            case 3 -> atendimentoPedagogico();
            case 4 -> relatorios();
            default -> System.out.println("\nValor invalido!");
        }
    }

    private void relatorios() {
        System.out.println("\n --- Relatórios --- ");

        try {

            System.out.println("\n[1]Relatório de alunos (Situação matricula)");
            System.out.println("[2]Relatório de professores (Experiencia)");
            System.out.println("[3]Relatório de alunos (Atendimentos pedagogicos)");
            System.out.println("[4]Relatório de pedagogos (Atendimentos pedagogicos)");
            System.out.println("[0]Sair");
            System.out.print("Opção: ");

            Integer opcao = scan.nextInt();

            if (opcao != 0) {
                seletorDeOpcoesRelatorio(opcao);
            }
        } catch (InputMismatchException e) {
            System.out.println("\nValor invalido!");
        }

    }

    private void seletorDeOpcoesRelatorio(Integer opcao) {
        switch (opcao) {
            case 1 -> relatorioAlunoMatricula();
            case 2 -> relatorioProfessorExperiencia();
            case 3 -> relatorioAlunoAtendimentosPedagogicos();
            case 4 -> relatorioPedagogoAtendimentosPedagogicos();
            default -> System.out.println("\nValor invalido!");

        }
    }

    private void relatorioPedagogoAtendimentosPedagogicos() {
        System.out.println("\n --- Relatório ---");

        alunoController.listar().forEach(a -> {

            List<Pedagogo> pedagogos = atendimentoPedagogicoController
                    .buscarAtendimentoPorPedagogo(a.getDocumento());

            System.out.println(pedagogos);

        });
    }

    private void relatorioAlunoAtendimentosPedagogicos() {
        System.out.println("\n --- Relatório ---");

        alunoController.listar().forEach(a -> {

            List<Aluno> alunos = atendimentoPedagogicoController
                    .buscarAtendimentoPorAluno(a.getDocumento());

            System.out.println(alunos);

        });
    }

    private void relatorioProfessorExperiencia() {
        System.out.println("\n --- Relatório --- ");

        try {
            System.out.println("\nSelecione a categoria: ");
            System.out.println("[1]Front_End");
            System.out.println("[2]Back_End");
            System.out.println("[3]Full_Stack");
            System.out.println("[4]Todos");
            System.out.println("[0]Sair");
            System.out.print("Opção: ");
            Integer opcao = scan.nextInt();

            if (opcao > 0 && opcao < 4) {
                professorController.relatorio(EnumExperienciaDesenvolvimento.getValor(opcao));
            } else if (opcao == 4) {
                professorController.listar();
            } else if (opcao < 0 && opcao > 4) {
                System.out.println("\n Valor invalido!");
            }

        } catch (InputMismatchException e) {
            System.out.println("\nValor invalido!");
        }

    }

    private void relatorioAlunoMatricula() {
        System.out.println("\n --- Relatório --- ");

        try {
            System.out.println("\nSelecione a categoria: ");
            System.out.println("[1]Ativo");
            System.out.println("[2]irregular");
            System.out.println("[3]Atendimento Pedagogico");
            System.out.println("[4]Inativo");
            System.out.println("[5]Todos");
            System.out.println("[0]Sair");
            System.out.print("Opção: ");
            Integer opcao = scan.nextInt();

            if (opcao > 0 && opcao < 5) {
                alunoController.relatorio(EnumMatricula.getValor(opcao));
            } else if (opcao == 5) {
                alunoController.listar();
            } else if (opcao < 0 && opcao > 5) {
                System.out.println("\n Valor invalido!");
            }

        } catch (InputMismatchException e) {
            System.out.println("\nValor invalido!");
        }
    }

    private void atendimentoPedagogico() {
        System.out.println("\n --- Atendimento Pedagogico --- ");

        Aluno aluno = alunoController.buscarPorCPF();
        Pedagogo pedagogo = pedagogoController.buscarPorCPF();

        atendimentoPedagogicoController.novoAtendimentoPedagogico(aluno, pedagogo);
    }

    private void alterarDados() {
        System.out.println("\n --- Alterar Dados --- ");
        try {

            System.out.println("\n[1]Aluno");
            System.out.println("[2]Professor");
            System.out.println("[3]Pedagogo");
            System.out.println("[0]Voltar");
            System.out.print("Opção: ");

            Integer opcao = scan.nextInt();

            if (opcao != 0) {
                seletorDeOpcoesAlterarDados(opcao);
            }

        } catch (InputMismatchException e) {
            System.out.println("\nValor invalido!");
        }
    }

    private void seletorDeOpcoesAlterarDados(Integer opcao) {
        switch (opcao) {
            case 1 -> alunoController.alterarDados();
            case 2 -> professorController.alterarDados();
            case 3 -> pedagogoController.alterarDados();
            default -> System.out.println("\nValor invalido!");

        }
    }

    private void novoCadastro() {
        System.out.println("\n --- Novo Cadastro --- ");
        try {

            System.out.println("\n[1]Cadastrar Aluno");
            System.out.println("[2]Cadastrar Professor");
            System.out.println("[3]Cadastrar Pedagogo");
            System.out.println("[0]Voltar");
            System.out.print("Opção: ");

            Integer opcao = scan.nextInt();

            if (opcao != 0) {
                seletorDeOpcoesCadastro(opcao);
            }

        } catch (InputMismatchException e) {
            System.out.println("\nValor invalido!");
        }

    }

    private void seletorDeOpcoesCadastro(Integer opcao) {
        switch (opcao) {
            case 1 -> alunoController.cadastrar();
            case 2 -> professorController.cadastrar();
            case 3 -> pedagogoController.cadastrar();
            default -> System.out.println("\nValor invalido!");

        }
    }

}
