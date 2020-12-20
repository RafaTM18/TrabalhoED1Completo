package TrabalhoED1ABB.elementos;

public class Diretorio extends Arquivo{
    private ArvoreBinariaBusca dir;

    public Diretorio(String chave) {
        super(chave);
        dir = new ArvoreBinariaBusca();
    }
    
    public ArvoreBinariaBusca getDir() {
        return dir;
    }

    public void setDir(ArvoreBinariaBusca dir) {
        this.dir = dir;
    }
    
}
