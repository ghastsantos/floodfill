class NoFila<T> {
    T dado;
    NoFila<T> proximo;

    public NoFila(T dado) {
        this.dado = dado;
        this.proximo = null;
    }
}

public class Fila<T> {
    private NoFila<T> inicio;
    private NoFila<T> fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    public void enfileirar(T dado) {
        NoFila<T> novoNo = new NoFila<>(dado);
        if (estaVazia()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.proximo = novoNo;
            fim = novoNo;
        }
    }

    public T desenfileirar() {
        if (estaVazia()) {
            return null;
        }
        T dadoRemovido = inicio.dado;
        inicio = inicio.proximo;

        if (inicio == null) {
            fim = null;
        }
        return dadoRemovido;
    }

    public boolean estaVazia() {
        return inicio == null;
    }
}