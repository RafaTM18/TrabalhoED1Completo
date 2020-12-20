package TrabalhoED1.comandos;

import TrabalhoED1.elementos.Arquivo;
import TrabalhoED1.elementos.Diretorio;
import TrabalhoED1.exceptions.DiretorioInexistenteException;
import TrabalhoED1.funcoes.Funcao;
import TrabalhoED1.elementos.ListaEncadeada;
import TrabalhoED1.path.InterpretaPath;

public class ComandoLs implements Funcao{
    //Comando feito por Kevin
    private String[] resComando;
    
    @Override
    public void fazFuncao(ListaEncadeada lista, String... resComando) throws Exception {
        Arquivo dir;      
        String aux;
        if(resComando.length == 1){
            lista.printLista("");
        }else if(resComando[1].equals("-R")){
            //recursiva
            if(resComando.length == 3){
                if(resComando[2].endsWith("/")){
                    resComando[2] = resComando[2].substring(0, resComando[2].length()-1);
                }
                dir = InterpretaPath.interpreta(lista,resComando[2]);
                aux = dir.getChave();
            }else{
                dir = lista.getRaiz();
                aux = "";
            }
            
            if(dir == null){ //Diretorio não existe
                throw new DiretorioInexistenteException(resComando[0], resComando[1]);
            }else if(!(dir instanceof Diretorio)){ //Ou seja, se ele for um arquivo base não é possivel imprir seu conteudo no nosso sistema
                 System.out.println(""+dir.getChave());
            }else{
                lista.printListaRecursivo(".", aux);
            } 
        }else{
            //não recursiva
            if(resComando[1].endsWith("/")){
                resComando[1] = resComando[1].substring(0, resComando[1].length()-1);
            }
            dir = InterpretaPath.interpreta(lista,resComando[1]);
            if(dir == null){ //Diretorio não existe
                throw new DiretorioInexistenteException(resComando[0], resComando[1]);
            }else if(!(dir instanceof Diretorio)){ //Ou seja, se ele for um arquivo base não é possivel imprir seu conteudo no nosso sistema
                System.out.println(""+dir.getChave());
            }else{
                ((Diretorio)dir).getDir().printLista(dir.getChave());
        
            }
        }
    }
    
}
