package TrabalhoED1AVL.elementos;

public class Diretorio extends Arquivo{
    private ArvoreAVL dir;

    public Diretorio(String chave) {
        super(chave);
        dir = new ArvoreAVL();
    }
    
    public ArvoreAVL getDir() {
        return dir;
    }

    public void setDir(ArvoreAVL dir) {
        this.dir = dir;
    }
    
}
