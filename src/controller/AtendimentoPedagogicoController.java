package controller;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import entities.Aluno;
import entities.AtendimentoPedagogico;
import entities.Pedagogo;

public class AtendimentoPedagogicoController {

    private static Set<AtendimentoPedagogico> atendimentos = new HashSet<>();

    public static final Scanner scan = new Scanner(System.in);

    public void novoAtendimentoPedagogico(Aluno aluno, Pedagogo pedagogo) {

        System.out.println("\nAtendimento pedagogico realizado!");
        System.out.println("\nPedagogo: " + pedagogo.getNome());
        System.out.println("Aluno: " + aluno.getNome());

        AtendimentoPedagogico atendimento = new AtendimentoPedagogico(pedagogo, aluno);

        atendimentos.add(atendimento);
    }

    public List<Aluno> buscarAtendimentoPorAluno(String cpf) {
        System.out.println("\n --- Buscar Atendimento --- ");

        List<Aluno> atendimentosLocalizados = atendimentos.stream().map(a -> a.getAluno())
                .filter(a -> a.getDocumento().equalsIgnoreCase(cpf)).collect(Collectors.toList());

        return atendimentosLocalizados;
    }

    public List<Pedagogo> buscarAtendimentoPorPedagogo(String cpf) {

        List<Pedagogo> atendimentosLocalizados = atendimentos.stream().map(p -> p.getPedagogo())
                .filter(a -> a.getDocumento().equalsIgnoreCase(cpf)).collect(Collectors.toList());

        return atendimentosLocalizados;

    }
}
