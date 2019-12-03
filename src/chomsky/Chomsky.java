package chomsky;

import java.io.IOException;

/**
 *
 * @author marce
 */
public class Chomsky {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Gramatica gramatica = Arquivo.lerEGravarGramatica();
        gramatica.imprime();
    }

}
