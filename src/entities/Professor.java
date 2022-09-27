package entities;

import enums.EnumExperienciaDesenvolvimento;
import enums.EnumFormacaoAcademica;

public class Professor extends Pessoa {

    private Integer formacaoAcademica;
    private Integer experienciaDesenvolvimento;
    private Boolean estado;

    public Professor(String nome, String documento, String dataNascimento, String telefone,
            EnumFormacaoAcademica formacaoAcademica, EnumExperienciaDesenvolvimento experienciaDesenvolvimento) {
        super(nome, documento, dataNascimento, telefone);
        this.formacaoAcademica = formacaoAcademica.getValorNumerico();
        this.experienciaDesenvolvimento = experienciaDesenvolvimento.getValorNumerico();
        this.estado = true;
    }

    public EnumExperienciaDesenvolvimento getExperienciaDesenvolvimento() {
        return EnumExperienciaDesenvolvimento.getValor(experienciaDesenvolvimento);
    }

    public void setExperienciaDesenvolvimento(EnumExperienciaDesenvolvimento experienciaDesenvolvimento) {
        this.experienciaDesenvolvimento = experienciaDesenvolvimento.getValorNumerico();
    }

    public EnumFormacaoAcademica getFormacaoAcademica() {
        return EnumFormacaoAcademica.getValor(formacaoAcademica);
    }

    public void setFormacaoAcademica(EnumFormacaoAcademica experienciaDesenvolvimento) {
        this.experienciaDesenvolvimento = experienciaDesenvolvimento.getValorNumerico();
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Professor [estado=" + estado + ", experienciaDesenvolvimento=" + experienciaDesenvolvimento
                + ", formacaoAcademica=" + formacaoAcademica + "]";
    }

}
