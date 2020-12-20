package TrabalhoED1.comandos;

import TrabalhoED1.elementos.Arquivo;
import TrabalhoED1.elementos.Diretorio;
import TrabalhoED1.exceptions.FaltaOperandoException;
import TrabalhoED1.funcoes.Funcao;
import TrabalhoED1.elementos.ListaEncadeada;
import TrabalhoED1.path.InterpretaPath;

public class ComandoSearch implements Funcao{
    //Comando feito por Alison e Gabriel
    private String[] resComando;
    
    @Override
    public void fazFuncao(ListaEncadeada lista, String... resComando) throws Exception {
        Arquivo dir;

        if (resComando.length == 1){
            throw new FaltaOperandoException(resComando[0]);
        }else if (resComando.length == 2){
            //não recursivo sem path
            lista.search(resComando[1]);
        }else if (resComando.length == 3) {
            if((resComando[1]).equals("-R")== true){
                //recursivo sem path
                lista.searchRec(resComando[2],".");
            }else{
                //não recursivo com path
                if(resComando[1].endsWith("/")){
                    resComando[1] = resComando[1].substring(0, resComando[1].length()-1);
                }
                dir = InterpretaPath.interpreta(lista, resComando[1]);
                ((Diretorio)dir).getDir().search(resComando[2]);
            }
            
            
        }else if (resComando.length == 4){
            //recursivo com path          
            if(resComando[2].endsWith("/")){
                resComando[2] = resComando[2].substring(0, resComando[2].length()-1);
            }
            dir = InterpretaPath.interpreta(lista, resComando[2]);            
            ((Diretorio)dir).getDir().searchRec(resComando[3], ".");
            
        }
    }
    
}
