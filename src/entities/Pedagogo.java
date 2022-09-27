package entities;

import java.util.Comparator;

public class Pedagogo extends Pessoa implements Comparator<Pedagogo> {

    public Pedagogo(String nome, String documento, String dataNascimento, String telefone) {
        super(nome, documento, dataNascimento, telefone);
    }

    @Override
    public int compare(Pedagogo pedagogo1, Pedagogo pedagogo2) {
        return pedagogo1.getId().compareTo(pedagogo2.getId());
    }

}
