package TrabalhoED1AVL.comandos;

import TrabalhoED1AVL.funcoes.Funcao;

public interface Comando {
    public abstract String getOpcao();
    public abstract Funcao getFuncao();
}
