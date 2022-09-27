package enums;

public enum EnumFormacaoAcademica {

    GRADUACAO_INCOMPLETA(1),
    GRADUACAO_COMPLETA(2),
    MESTRADO(3),
    DOUTORADO(4);

    private final Integer valorFormacaoAcademica;

    EnumFormacaoAcademica(Integer valorFormacaoAcademica) {
        this.valorFormacaoAcademica = valorFormacaoAcademica;
    }

    public Integer getValorNumerico() {
        return this.valorFormacaoAcademica;
    }

    public static EnumFormacaoAcademica getValor(Integer valorFormacao) {
        EnumFormacaoAcademica formacaoLocalizada = null;
        for (EnumFormacaoAcademica formacao : EnumFormacaoAcademica.values()) {
            if (formacao.getValorNumerico().equals(valorFormacao)) {
                formacaoLocalizada = formacao;
            }
        }
        return formacaoLocalizada;
    }

}
