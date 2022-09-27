package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Pessoa {

    private static Integer idGeral = 10000;

    private Integer id;
    private String nome;
    private String documento;
    private LocalDate dataNascimento;
    private String telefone;

    private Integer idade;

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Pessoa() {
        this.id = idGeral;
        idGeral++;
    }

    public Pessoa(String nome, String documento, String dataNascimento, String telefone) {
        this.id = idGeral;
        this.nome = nome;
        this.documento = documento;
        this.dataNascimento = LocalDate.parse(dataNascimento, dtf);
        this.telefone = telefone;
        this.idade = this.dataNascimento.minusYears(LocalDate.now().getYear()).getYear();
        idGeral++;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getDataNascimento() {
        return dtf.format(this.dataNascimento);
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = LocalDate.parse(dataNascimento, dtf);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Pessoa [dataNascimento=" + dtf.format(dataNascimento) + ", documento=" + documento + ", id=" + id
                + ", idade="
                + idade + ", nome=" + nome + ", telefone=" + telefone + "]";
    }

}
