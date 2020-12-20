package TrabalhoED1.elementos;

public class Arquivo {
    private String chave;
    private Arquivo prox;
    
    public Arquivo(String chave){
        this.chave = chave;
        this.prox = null;
    }
    
    @Override
    public boolean equals(Object obj){
        //Não usamos isso até agora lol
        if(obj instanceof Arquivo){
            if(this.chave.equals(((Arquivo)obj).chave)){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public Arquivo getProx() {
        return prox;
    }

    public void setProx(Arquivo prox) {
        this.prox = prox;
    }
    
}
