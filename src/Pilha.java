class NoPilha<T> {
    T dado;
    NoPilha<T> abaixo;

    public NoPilha(T dado) {
        this.dado = dado;
        this.abaixo = null;
    }
}

public class Pilha<T> {
    private NoPilha<T> topo;

    public Pilha() {
        this.topo = null;
    }

    public void empilhar(T dado) {
        NoPilha<T> novoNo = new NoPilha<>(dado);
        novoNo.abaixo = topo;
        topo = novoNo;
    }

    public T desempilhar() {
        if (estaVazia()) {
            return null;
        }
        T dadoRemovido = topo.dado;
        topo = topo.abaixo;
        return dadoRemovido;
    }

    public boolean estaVazia() {
        return topo == null;
    }
}