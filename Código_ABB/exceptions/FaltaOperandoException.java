package TrabalhoED1ABB.exceptions;

public class FaltaOperandoException extends Exception{
    public FaltaOperandoException(String op){
        super(op + ": missing operand");
    }
}
