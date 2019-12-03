package chomsky;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author marcella menezes
 */
public class Arquivo {

    public static Gramatica lerEGravarGramatica() throws FileNotFoundException, IOException {
        List<String> estados;
        List<String> terminais;
        List<Producao> producoes;
        String start;
        try {
            FileReader arq = new FileReader("gramatica.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            //Adicionando a lista de estados
            String vetEstados[] = (lerArq.readLine()).split(";");
            estados = new ArrayList<>();
            estados.addAll(Arrays.asList(vetEstados));

            //Adicionando a lista de Terminais
            String vetTerminais[] = (lerArq.readLine()).split(";");
            terminais = new ArrayList<>();
            terminais.addAll(Arrays.asList(vetTerminais));

            //Adicionando o start
            start = lerArq.readLine();

            //Adicionar os destinos de um estado
            String linhaProducao = lerArq.readLine();
            producoes = new ArrayList<>();

            for (int i = 0; linhaProducao != null; i++) {
                String vetProducao[] = linhaProducao.split(">");
                String estado = vetProducao[0];
                String vetDestinos[] = vetProducao[1].split(";"); // destinos de uma producao

                List<Destino> destinos = new ArrayList<>(); // Array com todos os destino de uma producao

                for (int j = 0; j < vetDestinos.length; j++) {
                    Destino destino = new Destino(Utilidades.separaDestino(vetDestinos[j]));//"conjunto" de um destino
                    destinos.add(destino);
                }

                producoes.add(new Producao(estado, destinos)); // adiciona a producao (estado, destinos)

                linhaProducao = lerArq.readLine();
            }

            return new Gramatica(estados, terminais, producoes, start);
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
            return null;
        }

    }
}
