package TrabalhoED1.exceptions;

public class ArquivoExistenteException extends Exception{
    public ArquivoExistenteException(String op){
        super("touch: File " + op + " already exists");
    }
}
