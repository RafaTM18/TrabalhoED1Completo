package TrabalhoED1ABB.exceptions;

public class NomeInvalidoException extends Exception{
    public NomeInvalidoException(String op){
        super("mkdir/touch: Cannot create " + op + ": File name is too big");
    }
}
