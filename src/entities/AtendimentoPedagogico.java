package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AtendimentoPedagogico {

    private Pedagogo pedagogo;
    private Aluno aluno;
    private LocalDate dataAtendimento;

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public AtendimentoPedagogico(Pedagogo pedagogo, Aluno aluno) {
        this.pedagogo = pedagogo;
        this.aluno = aluno;
        this.dataAtendimento = LocalDate.now();
    }

    public Pedagogo getPedagogo() {
        return pedagogo;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public String getDataAtendimento() {
        return dtf.format(dataAtendimento);
    }

    @Override
    public String toString() {
        return "AtendimentoPedagogico [aluno=" + aluno + ", pedagogo=" + pedagogo + ", data do atendimento "
                + dtf.format(dataAtendimento) + "]";
    }

}
