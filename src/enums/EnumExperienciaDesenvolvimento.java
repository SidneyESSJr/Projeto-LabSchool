package enums;

public enum EnumExperienciaDesenvolvimento {

    FRONT_END(1),
    BACK_END(2),
    FULL_STACK(3);

    private final Integer valorExperienciaDesenvolvimento;

    EnumExperienciaDesenvolvimento(Integer valorExperienciaDesenvolvimento) {
        this.valorExperienciaDesenvolvimento = valorExperienciaDesenvolvimento;
    }

    public Integer getValorNumerico() {
        return this.valorExperienciaDesenvolvimento;
    }

    public static EnumExperienciaDesenvolvimento getValor(Integer valorExperiencia) {
        EnumExperienciaDesenvolvimento experienciaLocalizada = null;
        for (EnumExperienciaDesenvolvimento experiencia : EnumExperienciaDesenvolvimento.values()) {
            if (experiencia.getValorNumerico().equals(valorExperiencia)) {
                experienciaLocalizada = experiencia;
            }
        }
        return experienciaLocalizada;
    }

}
