package TrabalhoED1ABB.exceptions;

public class ComandoInvalidoException extends Exception{

    public ComandoInvalidoException(String op) {
        super("Bash: " + op + ": command not found");
    }
    
}

