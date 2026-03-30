import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GerenciadorDeImagem {

    public BufferedImage carregar(String caminho) {
        File arquivoEntrada = new File(caminho);
        try {
            BufferedImage imagem = ImageIO.read(arquivoEntrada);
            if (imagem == null) {
                System.out.println("Erro: Não foi possível ler a imagem no caminho: " + caminho);
            }
            return imagem;
        } catch (IOException e) {
            System.out.println("Erro de leitura: " + e.getMessage());
            return null;
        }
    }

    public void salvarFrameNaPasta(BufferedImage imagem, String nomePasta, int contador) {
        try {
            File pasta = new File(nomePasta);

            if (!pasta.exists()) {
                pasta.mkdirs();
            }

            String nomeArquivo = "frame_" + contador + ".png";
            File arquivoFrame = new File(pasta, nomeArquivo);

            ImageIO.write(imagem, "PNG", arquivoFrame);

        } catch (IOException e) {
            System.out.println("Erro ao salvar o frame " + contador + " na pasta " + nomePasta + ": " + e.getMessage());
        }
    }
}