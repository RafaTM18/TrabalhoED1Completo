package TrabalhoED1.comandos;

import TrabalhoED1.elementos.Arquivo;
import TrabalhoED1.elementos.Diretorio;
import TrabalhoED1.exceptions.ArquivoExistenteException;
import TrabalhoED1.exceptions.DiretorioExistenteException;
import TrabalhoED1.exceptions.DiretorioInexistenteException;
import TrabalhoED1.exceptions.FaltaOperandoException;
import TrabalhoED1.exceptions.NaoEDiretorioException;
import TrabalhoED1.funcoes.Funcao;
import TrabalhoED1.elementos.ListaEncadeada;
import TrabalhoED1.path.InterpretaPath;

public class ComandoTouch implements Funcao{
    //Comando feito por Rafael
    
    @Override
    public void fazFuncao(ListaEncadeada lista, String... resComando) throws Exception {
        //Não difere muito do mkdir além da parte que é adicionado um arquivo invés de um diretório
        int index;
        
        if(resComando.length == 1){
            throw new FaltaOperandoException(resComando[0]);
        }else if(resComando.length == 2){
            if(resComando[1].contains("/")){
                if(resComando[1].endsWith("/")){
                    resComando[1] = resComando[1].substring(0, resComando[1].length()-1);
                }
                index = resComando[1].lastIndexOf('/');
                Arquivo dir = InterpretaPath.interpreta(lista, resComando[1].substring(0, index));
                if(dir == null){
                    throw new DiretorioInexistenteException(resComando[0], resComando[1]);
                }else if(!(dir instanceof Diretorio)){
                    throw new NaoEDiretorioException(resComando[0], resComando[1]);
                }else{
                    if(((Diretorio) dir).getDir().procuraArquivo(resComando[1].substring(index+1)) == null)
                        ((Diretorio) dir).getDir().addArquivo(resComando[1].substring(index+1));
                }
            }else{
                if(lista.procuraArquivo(resComando[1]) == null)
                    lista.addArquivo(resComando[1]);
            }
        }
    }
    
}
