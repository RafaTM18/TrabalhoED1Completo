package TrabalhoED1AVL.validacao;

import TrabalhoED1AVL.exceptions.NomeInvalidoException;

public class ValidaTamanhoArq {
    public static void validador(String nome) throws NomeInvalidoException{
        if(nome.length() > 50)
            throw new NomeInvalidoException(nome);
    }
}
