package TrabalhoED1.elementos;

import java.util.ArrayList;


public class ListaEncadeada {
    private Arquivo raiz;
    
    public ListaEncadeada(){
        this.raiz = null;
    }
    
    public Arquivo getRaiz() {
        return raiz;
    }

    public void setRaiz(Arquivo raiz) {
        this.raiz = raiz;
    }
    
    public void addArquivo(String chave){
        Arquivo novoArq = new Arquivo(chave);
        if(this.raiz == null || novoArq.getChave().compareTo(this.raiz.getChave()) < 0){
            novoArq.setProx(this.raiz);
            this.raiz = novoArq;
        }else{
            Arquivo atual = this.raiz;
            while(atual.getProx() != null && atual.getProx().getChave().compareTo(novoArq.getChave()) < 0)
                atual = atual.getProx();
            
            novoArq.setProx(atual.getProx());
            atual.setProx(novoArq);
        }
    }
    
    public void addDiretorio(String chave){
        Arquivo novoDir = new Diretorio(chave);
        if (this.raiz == null || novoDir.getChave().compareTo(this.raiz.getChave()) < 0) {
            novoDir.setProx(this.raiz);
            this.raiz = novoDir;
        } else {
            Arquivo atual = this.raiz;
            while (atual.getProx() != null && atual.getProx().getChave().compareTo(novoDir.getChave()) < 0) {
                atual = atual.getProx();
            }

            novoDir.setProx(atual.getProx());
            atual.setProx(novoDir);
        }
    }
    
    public void search(String chave){
        //Procura um elemento na lista atual
        Arquivo atual = this.raiz;
        
        while(atual != null){
            if(atual.getChave().equals(chave)){
                System.out.println("./" + atual.getChave());
            }
            atual = atual.getProx();
        }       
    }
    
    public void searchRec(String chave, String caminho){
        ArrayList<Diretorio> dirsAvisitar = new ArrayList<>();
        Arquivo atual = this.raiz;
        //caminho = caminho;
        while(atual != null){           
            if(atual.getChave().equals(chave)){
                System.out.println(caminho + "/" + chave);
            }
            if(atual instanceof Diretorio){
                dirsAvisitar.add((Diretorio)atual);
            }
            atual = atual.getProx();
        }
        for(Diretorio d:dirsAvisitar){
            d.getDir().searchRec(chave, caminho + "/" + d.getChave());
        }
    }
    
    public void printLista(String nomeDir){
        //Mostra os elementos dessa lista
        System.out.println("./"+ nomeDir+":");
        Arquivo atual = this.raiz;
        if(this.raiz == null){
            //quando o caminho esta vazio simplesmente não mostra nada
            System.out.println();
        }
        
        while(atual != null){
            System.out.println(atual.getChave());
            atual = atual.getProx();
        }
        
    }

    public void printListaRecursivo(String caminho,String nomeDir) {
        Arquivo prox = this.getRaiz();
        ArrayList<Diretorio> dirsAvisitar = new ArrayList<>();
        if(!nomeDir.equals("")){
            caminho = caminho.concat("/" + nomeDir);
        }
        System.out.println("" + caminho +":");
        
        
        while(prox != null){           
            System.out.println(" " + prox.getChave());
            if(prox instanceof Diretorio){
                dirsAvisitar.add((Diretorio)prox);
            }
            prox = prox.getProx();
        }
        System.out.println("");
        for(Diretorio d:dirsAvisitar){
            d.getDir().printListaRecursivo(caminho, d.getChave());
        }
    
    }
    
    public Arquivo procuraArquivo(String chave){
        //Procura um elemento na lista atual
        Arquivo atual = this.raiz;
        
        while(atual != null){
            if(atual.getChave().equals(chave))
                return atual;
            atual = atual.getProx();
        }
        return null;
    }
    
}
