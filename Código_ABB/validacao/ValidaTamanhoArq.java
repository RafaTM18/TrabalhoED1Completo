package TrabalhoED1ABB.validacao;

import TrabalhoED1ABB.exceptions.NomeInvalidoException;

public class ValidaTamanhoArq {
    public static void validador(String nome) throws NomeInvalidoException{
        if(nome.length() > 50)
            throw new NomeInvalidoException(nome);
    }
}
