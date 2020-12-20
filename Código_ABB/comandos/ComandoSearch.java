package TrabalhoED1ABB.comandos;

import TrabalhoED1ABB.elementos.Arquivo;
import TrabalhoED1ABB.elementos.ArvoreBinariaBusca;
import TrabalhoED1ABB.elementos.Diretorio;
import TrabalhoED1ABB.exceptions.ComandoInvalidoException;
import TrabalhoED1ABB.funcoes.Funcao;

public class ComandoSearch implements Funcao{

    @Override
    public void fazFuncao(ArvoreBinariaBusca arvore, String... resComando) throws Exception {
        if(resComando.length == 2){
            
            arvore.procuraChave(".", resComando[1]);
        }else if(resComando.length == 3){
            if(resComando[1].equals("-R")){
                //recursivo
                arvore.procuraChaveRec(".","", resComando[2]);
            }else{
                //não recursivo
                
                Arquivo dir = arvore.interpretaPath(resComando[1]);
                ((Diretorio)dir).getDir().procuraChave("./" + resComando[1], resComando[2]);
            }
        }else if(resComando.length == 4){
            Arquivo dir = arvore.interpretaPath(resComando[2]);
            ((Diretorio)dir).getDir().procuraChaveRec("./" + resComando[2],"", resComando[3]);
        }else{
            throw new ComandoInvalidoException(resComando[0]);
        }
        
    }
    
}
