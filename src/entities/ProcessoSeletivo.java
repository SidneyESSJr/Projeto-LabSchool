package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProcessoSeletivo {

    private Aluno aluno;
    private LocalDate data;
    private Double nota;
    private Boolean status;

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public ProcessoSeletivo(Aluno aluno, Double nota) {
        this.aluno = aluno;
        this.data = LocalDate.now();
        this.nota = nota;
        atualizarStatus();
    }

    public String getStatus() {
        if (this.status) {
            return "APROVADO";
        } else {
            return "REPROVADO";
        }
    }

    public void atualizarStatus() {
        if (this.nota >= 7) {
            this.status = true;
        } else {
            this.status = false;
        }
    }

    public Aluno getAluno() {
        return aluno;
    }

    public LocalDate getData() {
        return data;
    }

    public Double getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "ProcessoSeletivo [aluno=" + aluno + ", data=" + dtf.format(data) + ", nota=" + nota + ", status="
                + status + "]";
    }

}
