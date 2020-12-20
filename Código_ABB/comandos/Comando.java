package TrabalhoED1ABB.comandos;

import TrabalhoED1ABB.funcoes.Funcao;

public interface Comando {
    public abstract String getOpcao();
    public abstract Funcao getFuncao();
}
