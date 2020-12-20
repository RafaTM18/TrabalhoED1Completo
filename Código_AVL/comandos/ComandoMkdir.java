package TrabalhoED1AVL.comandos;

import TrabalhoED1AVL.elementos.Arquivo;
import TrabalhoED1AVL.elementos.ArvoreAVL;
import TrabalhoED1AVL.elementos.Diretorio;
import TrabalhoED1AVL.exceptions.DiretorioExistenteException;
import TrabalhoED1AVL.exceptions.DiretorioInexistenteException;
import TrabalhoED1AVL.exceptions.FaltaOperandoException;
import TrabalhoED1AVL.exceptions.NaoEDiretorioException;
import TrabalhoED1AVL.funcoes.Funcao;
import TrabalhoED1AVL.validacao.ValidaTamanhoArq;
import TrabalhoED1AVL.validacao.ValidaTamanhoPath;

public class ComandoMkdir implements Funcao{

    @Override
    public void fazFuncao(ArvoreAVL arvore, String... resComando) throws Exception {
        int index;
        
        if(resComando.length == 1){ //Não foi adicionado qual chave deseja adicionar
            throw new FaltaOperandoException(resComando[0]);
        }else if(resComando.length == 2){
            if(resComando[1].contains("/")){ //Com path
                if(resComando[1].endsWith("/")){
                    resComando[1] = resComando[1].substring(0, resComando[1].length()-1);
                }
                index = resComando[1].lastIndexOf('/'); //Separa a chave a ser adicionada do path
                ValidaTamanhoArq.validador(resComando[1].substring(index+1));
                ValidaTamanhoPath.validador(resComando[1]);
                Arquivo dir = arvore.interpretaPath(resComando[1].substring(0, index));
                if(dir == null){
                    throw new DiretorioInexistenteException(resComando[0], resComando[1]);
                }else if(!(dir instanceof Diretorio)){
                    throw new NaoEDiretorioException(resComando[0], resComando[1]);
                }else{
                    if(((Diretorio) dir).getDir().procuraArquivo(resComando[1].substring(index+1)) != null)
                        throw new DiretorioExistenteException(resComando[1]);
                    ((Diretorio) dir).getDir().addDiretorio(resComando[1].substring(index+1));
                }
            }else{ //sem path
                ValidaTamanhoArq.validador(resComando[1]);
                if(arvore.procuraArquivo(resComando[1]) != null)
                    throw new DiretorioExistenteException(resComando[1]);
                arvore.addDiretorio(resComando[1]);
            }
        }
    }
    
}
