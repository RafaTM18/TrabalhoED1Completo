package TrabalhoED1ABB.validacao;

import TrabalhoED1ABB.exceptions.PathInvalidoException;

public class ValidaTamanhoPath {
    public static void validador(String path) throws PathInvalidoException{
        int count = path.length() - path.replaceAll("/", "").length();
        if(!(count < 100)){
            throw new PathInvalidoException();
        }
    }
}
