package TrabalhoED1AVL.exceptions;

public class PathInvalidoException extends Exception{
    public PathInvalidoException(){
        super("mkdir/touch: Cannot create file: Too many directories");
    }
}
