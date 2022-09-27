package interfaces;

import java.util.Set;

public interface IntegranteEscola<T> {

    abstract void cadastrar();

    abstract T buscarPorCPF();

    abstract void alterarDados();

    abstract Set<T> listar();

}
