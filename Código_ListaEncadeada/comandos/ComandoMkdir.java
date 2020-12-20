package TrabalhoED1.comandos;

import TrabalhoED1.elementos.Arquivo;
import TrabalhoED1.elementos.Diretorio;
import TrabalhoED1.exceptions.DiretorioExistenteException;
import TrabalhoED1.exceptions.DiretorioInexistenteException;
import TrabalhoED1.exceptions.FaltaOperandoException;
import TrabalhoED1.exceptions.NaoEDiretorioException;
import TrabalhoED1.funcoes.Funcao;
import TrabalhoED1.elementos.ListaEncadeada;
import TrabalhoED1.path.InterpretaPath;

public class ComandoMkdir implements Funcao{
    //Comando feito por Rafael
    private String[] resComando;

    @Override
    public void fazFuncao(ListaEncadeada lista, String... resComando) throws Exception {
        int index;
        
        if(resComando.length == 1){
            throw new FaltaOperandoException(resComando[0]);
        }else if(resComando.length == 2){
            if(resComando[1].contains("/")){
                //No caso de conter o char / siginifica que o usuario provavelmente digitou
                //um path, então é armazenado a posição do último / para poder saber qual chave
                //do novo diretorio ser inserido
                if(resComando[1].endsWith("/")){
                    resComando[1] = resComando[1].substring(0, resComando[1].length()-1);
                }
                index = resComando[1].lastIndexOf('/');
                Arquivo dir = InterpretaPath.interpreta(lista, resComando[1].substring(0, index));
                if(dir == null){ //Diretorio não existe
                    throw new DiretorioInexistenteException(resComando[0], resComando[1]);
                }else if(!(dir instanceof Diretorio)){ //Ou seja, se ele for um arquivo base
                    throw new NaoEDiretorioException(resComando[0], resComando[1]);
                }else{
                    if(((Diretorio) dir).getDir().procuraArquivo(resComando[1].substring(index+1)) != null)
                        throw new DiretorioExistenteException(resComando[1]);
                    ((Diretorio) dir).getDir().addDiretorio(resComando[1].substring(index+1));
                    //Add diretorio na lista, duuh
                }
            }else{
                //Nesse caso, é diretamente inserido na raiz
                if(lista.procuraArquivo(resComando[1]) != null)
                    throw new DiretorioExistenteException(resComando[1]);
                lista.addDiretorio(resComando[1]);
            }
            
        }
        
    }
    
}
