package enums;

public enum EnumMatricula {

    ATIVO(1),
    IRREGULAR(2),
    ATENDIMENTO_PEDAGOGICO(3),
    INATIVO(4);

    private final Integer valorMatricula;

    EnumMatricula(Integer valorMatricula) {
        this.valorMatricula = valorMatricula;
    }

    public Integer getValorNumerico() {
        return this.valorMatricula;
    }

    public static EnumMatricula getValor(Integer valorMatricula) {
        EnumMatricula matriculaLocalizada = null;
        for (EnumMatricula matricula : EnumMatricula.values()) {
            if (matricula.getValorNumerico().equals(valorMatricula)) {
                matriculaLocalizada = matricula;
            }
        }
        return matriculaLocalizada;
    }
}