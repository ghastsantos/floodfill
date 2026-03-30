import java.awt.*;
import java.awt.image.BufferedImage;

public class Main {
    public static void main(String[] args) {
        GerenciadorDeImagem gerenciador = new GerenciadorDeImagem();
        BufferedImage imagemParaPilha = gerenciador.carregar("src/pixels.png");
        BufferedImage imagemParaFila = gerenciador.carregar("src/pixels.png");

        if (imagemParaPilha == null || imagemParaFila == null) {
            System.out.println("Erro ao carregar as imagens. Encerrando.");
            return;
        }

        int corNova = Color.BLACK.getRGB();
        int xInicial = 2;
        int yInicial = 2;

        FloodFill algoritmo = new FloodFill();

        System.out.println("Iniciando preenchimento com Pilha...");
        algoritmo.preencherComPilha(imagemParaPilha, xInicial, yInicial, corNova, gerenciador);

        System.out.println("Iniciando preenchimento com Fila...");
        algoritmo.preencherComFila(imagemParaFila, xInicial, yInicial, corNova, gerenciador);

        System.out.println("Trabalho concluído! Verifique as pastas geradas.");
    }
}