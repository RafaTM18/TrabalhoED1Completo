package TrabalhoED1ABB.elementos;

public class Arquivo {
    private String chave;
    private Arquivo esquerdo;
    private Arquivo direito;
    
    public Arquivo(String chave){
        this.chave = chave;
        this.esquerdo = null;
        this.esquerdo = null;
    }

    
    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Arquivo getEsquerdo() {
        return esquerdo;
    }

    public void setEsquerdo(Arquivo esquerdo) {
        this.esquerdo = esquerdo;
    }

    public Arquivo getDireito() {
        return direito;
    }

    public void setDireito(Arquivo direito) {
        this.direito = direito;
    }
    
}
