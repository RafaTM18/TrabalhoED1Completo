package TrabalhoED1.comandos;

import TrabalhoED1.exceptions.ComandoInvalidoException;
import TrabalhoED1.funcoes.Funcao;

public enum ComandoLinux implements Comando{
    MKDIR("mkdir", new ComandoMkdir()),
    TOUCH("touch", new ComandoTouch()),
    LIST("ls", new ComandoLs()),
    SEARCH("search", new ComandoSearch());
    
    private String opcao;
    private Funcao funcao;

    private ComandoLinux(String opcao, Funcao funcao) {
        this.opcao = opcao;
        this.funcao = funcao;
    }

    @Override
    public String getOpcao() {
        return opcao;
    }

    @Override
    public Funcao getFuncao() {
        return funcao;
    }
    
    public static ComandoLinux opcaoPelaString(String op) throws ComandoInvalidoException{
        for(ComandoLinux comando : ComandoLinux.values()){
            //percorre os valores de ComandoLinux para ver se o comando dado é valido
            if(comando.opcao.equals(op)){
                return comando;
            }
        }
        throw new ComandoInvalidoException(op);
    }
}
