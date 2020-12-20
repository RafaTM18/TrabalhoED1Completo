package TrabalhoED1.exceptions;

public class FaltaOperandoException extends Exception{
    public FaltaOperandoException(String op){
        super(op + ": missing operand");
    }
}
