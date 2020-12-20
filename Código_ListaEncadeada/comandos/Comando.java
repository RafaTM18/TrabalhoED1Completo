package TrabalhoED1.comandos;

import TrabalhoED1.funcoes.Funcao;

public interface Comando {
    public abstract String getOpcao();
    public abstract Funcao getFuncao();
}
