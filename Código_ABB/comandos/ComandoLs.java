package TrabalhoED1ABB.comandos;

import TrabalhoED1ABB.elementos.Arquivo;
import TrabalhoED1ABB.elementos.ArvoreBinariaBusca;
import static TrabalhoED1ABB.elementos.ArvoreBinariaBusca.printArvoreRecursivo;
import TrabalhoED1ABB.elementos.Diretorio;
import TrabalhoED1ABB.exceptions.DiretorioInexistenteLSException;
import TrabalhoED1ABB.funcoes.Funcao;


public class ComandoLs implements Funcao{

    @Override
    public void fazFuncao(ArvoreBinariaBusca arvore, String... resComando) throws Exception {
        
        ArvoreBinariaBusca dir; 
        Arquivo aux = null;
        if(resComando.length == 1){
            arvore.printArvore("");
        }else if(resComando[1].equals("-R")){
            //recursiva
            if(resComando.length == 3){
                aux = arvore.interpretaPath(resComando[2]);
                if(aux == null){ //Diretorio não existe
                    throw new DiretorioInexistenteLSException();
                }else if(!(aux instanceof Diretorio)){ //Ou seja, se ele for um arquivo base não é possivel imprir seu conteudo no nosso sistema
                    throw new DiretorioInexistenteLSException();
                }
                printArvoreRecursivo(".", ((Diretorio)aux).getDir(),resComando[2]);
            }else{
                dir = arvore;       
                printArvoreRecursivo(".", dir,"");
            }

        }else{
            //não recursiva
            aux = arvore.interpretaPath(resComando[1]);
             if(aux == null){ //Diretorio não existe
                throw new DiretorioInexistenteLSException();
            }else if(!(aux instanceof Diretorio)){ //Ou seja, se ele for um arquivo base não é possivel imprir seu conteudo no nosso sistema
                throw new DiretorioInexistenteLSException();
            }else{
                ((Diretorio)aux).getDir().printArvore(aux.getChave());
        
            }
        }
    }
    
}
