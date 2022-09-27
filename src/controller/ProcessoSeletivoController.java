package controller;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

import entities.Aluno;
import entities.ProcessoSeletivo;

public class ProcessoSeletivoController {

    private static Set<ProcessoSeletivo> processos = new HashSet<>();

    public static final Scanner scan = new Scanner(System.in);

    public static void novoProcessoSeletivo(Aluno aluno) {
        ProcessoSeletivo processo = null;

        System.out.println("\n --- Processo Seletivo --- ");
        try {

            System.out.print("\nNota do aluno: ");
            Double nota = scan.nextDouble();
            processo = new ProcessoSeletivo(aluno, nota);
            processos.add(processo);

            System.out.println("\nProcesso finalizado!");
            System.out.println("\nAluno: " + aluno.getNome() + "\nStatus: " + processo.getStatus());

        } catch (InputMismatchException e) {
            System.out.println("\nValor invalido!");
        }
    }

    public static void buscarProcessoPorAluno() {
        System.out.println("\n --- Buscar Processo Seletivo --- ");

        try {

            System.out.print("\nCPF aluno: ");
            String cpf = scan.next();

            ProcessoSeletivo processo = processos.stream()
                    .filter(p -> p.getAluno().getDocumento().equalsIgnoreCase(cpf)).findFirst().orElseThrow();

            System.out.println(processo);

        } catch (NoSuchElementException e) {
            System.out.println("\nValor não localizado");
        }
    }

}
