package entities;

import java.util.Comparator;

import enums.EnumMatricula;

public class Aluno extends Pessoa implements Comparator<Aluno> {

    private Integer matricula;

    public Aluno(String nome, String documento, String dataNascimento, String telefone) {
        super(nome, documento, dataNascimento, telefone);
        this.matricula = EnumMatricula.ATIVO.getValorNumerico();

    }

    public EnumMatricula getMatricula() {
        return EnumMatricula.getValor(matricula);
    }

    public void setMatricula(EnumMatricula matricula) {
        this.matricula = matricula.getValorNumerico();
    }

    @Override
    public String toString() {
        return "Aluno [matricula=" + matricula + "]";
    }

    @Override
    public int compare(Aluno aluno1, Aluno aluno2) {
        return aluno1.getId().compareTo(aluno2.getId());
    }

}
