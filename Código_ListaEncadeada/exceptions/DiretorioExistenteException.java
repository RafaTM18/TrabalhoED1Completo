package TrabalhoED1.exceptions;

public class DiretorioExistenteException extends Exception {
    
    public DiretorioExistenteException(String op){
        super("mkdir: cannot create directory '" + op + "': File exists");
    }
    
}
