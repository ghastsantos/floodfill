import java.awt.image.BufferedImage;

public class FloodFill {
    public void preencherComPilha(BufferedImage imagem, int xInicial, int yInicial, int corNova, GerenciadorDeImagem gerenciador) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        int corDeFundo = imagem.getRGB(xInicial, yInicial);

        if (corDeFundo == corNova) {
            System.out.println("A cor nova é igual à cor de fundo. Abortando.");
            return;
        }

        Pilha<Coordenada> pilha = new Pilha<>();
        pilha.empilhar(new Coordenada(xInicial, yInicial));

        int contadorFrames = 0;

        while (!pilha.estaVazia()) {
            Coordenada atual = pilha.desempilhar();
            int x = atual.x;
            int y = atual.y;

            if (x < 0 || x >= largura || y < 0 || y >= altura) {
                continue;
            }

            if (imagem.getRGB(x, y) != corDeFundo) {
                continue;
            }

            imagem.setRGB(x, y, corNova);

            gerenciador.salvarFrameNaPasta(imagem, "frames_pilha", contadorFrames);
            contadorFrames++;

            pilha.empilhar(new Coordenada(x - 1, y)); // Esquerda
            pilha.empilhar(new Coordenada(x + 1, y)); // Direita
            pilha.empilhar(new Coordenada(x, y + 1)); // Baixo
            pilha.empilhar(new Coordenada(x, y - 1)); // Cima
        }
    }

    public void preencherComFila(BufferedImage imagem, int xInicial, int yInicial, int corNova, GerenciadorDeImagem gerenciador) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();
        int corDeFundo = imagem.getRGB(xInicial, yInicial);

        if (corDeFundo == corNova) {
            System.out.println("A cor nova é igual à cor de fundo. Abortando.");
            return;
        }

        Fila<Coordenada> fila = new Fila<>();
        fila.enfileirar(new Coordenada(xInicial, yInicial));

        int contadorFrames = 0;

        while (!fila.estaVazia()) {
            Coordenada atual = fila.desenfileirar();
            int x = atual.x;
            int y = atual.y;

            if (x < 0 || x >= largura || y < 0 || y >= altura) {
                continue;
            }

            if (imagem.getRGB(x, y) != corDeFundo) {
                continue;
            }

            imagem.setRGB(x, y, corNova);

            gerenciador.salvarFrameNaPasta(imagem, "frames_fila", contadorFrames);
            contadorFrames++;

            fila.enfileirar(new Coordenada(x + 1, y)); // Direita
            fila.enfileirar(new Coordenada(x - 1, y)); // Esquerda
            fila.enfileirar(new Coordenada(x, y + 1)); // Baixo
            fila.enfileirar(new Coordenada(x, y - 1)); // Cima
        }
    }
}