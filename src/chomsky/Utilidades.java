package chomsky;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class Utilidades {

    public static void imprime(String nome, List<String> vet) {
        System.out.print(nome + " ");
        for (String valor : vet) {
            System.out.print(valor + "\t");
        }
        System.out.println("");
    }

    static void imprime(String nome, String[] vetDestinos) {
        System.out.print(nome + " ");
        for (String valor : vetDestinos) {
            System.out.print(valor + "\t");
        }
        System.out.println("");
    }

    public static List separaDestino(String destino) {
        List<String> destinos = new ArrayList<>();
        int tamanhoDestino = destino.length();
        for (int i = 0; i < tamanhoDestino; i++) {
            destinos.add(destino.charAt(i) + "");
        }
        return destinos;
    }

}
