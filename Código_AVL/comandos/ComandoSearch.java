package TrabalhoED1AVL.comandos;

import TrabalhoED1AVL.elementos.Arquivo;
import TrabalhoED1AVL.elementos.ArvoreAVL;
import TrabalhoED1AVL.elementos.Diretorio;
import TrabalhoED1AVL.exceptions.FaltaOperandoException;
import TrabalhoED1AVL.funcoes.Funcao;

public class ComandoSearch implements Funcao{

    @Override
    public void fazFuncao(ArvoreAVL arvore, String... resComando) throws Exception {
        if(resComando.length == 2){
            arvore.procuraChave(".", resComando[1]);
        }else if(resComando.length == 3){
            if(resComando[1].equals("-R")){
                //recursivo
                arvore.procuraChaveRec(".","", resComando[2]);
            }else{
                //não recursivo
                if(resComando[1].endsWith("/")){
                    resComando[1] = resComando[1].substring(0, resComando[1].length()-1);
                }
                Arquivo dir = arvore.interpretaPath(resComando[1]);
                ((Diretorio)dir).getDir().procuraChave("./" + resComando[1], resComando[2]);
            }
        }else if(resComando.length == 4){
            if(resComando[2].endsWith("/")){
                    resComando[2] = resComando[2].substring(0, resComando[2].length()-1);
                }
            Arquivo dir = arvore.interpretaPath(resComando[2]);
            ((Diretorio)dir).getDir().procuraChaveRec("./" + resComando[2],"", resComando[3]);
        }else{
            throw new FaltaOperandoException(resComando[0]);
        }
        
    }
    
}
