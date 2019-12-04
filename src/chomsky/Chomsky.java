package chomsky;

import java.io.IOException;

/**
 *
 * @author marce
 */
public class Chomsky {

        public static void main(String[] args) throws IOException {
                Gramatica gramatica = Arquivo.lerEGravarGramatica();
                gramatica.imprime();
                //SimplificacaoGLC.eliminarVariaveisInalcancaveis(gramatica);
                //gramatica.imprime();
                Producao producaoStart = SimplificacaoGLC.producaoStart(gramatica);
                SimplificacaoGLC.estadosDaProducao(producaoStart, gramatica);
                SimplificacaoGLC.variaveisAlcancaveis(gramatica);
                SimplificacaoGLC.variaveisInalcancaveis(gramatica);
                SimplificacaoGLC.variaveisAlcancaveisIndiretamente(gramatica);
                System.out.println("Alcancavel: " + SimplificacaoGLC.verificaSeTodosSaoAlcancaveis(gramatica, gramatica.getEstados()));
        }

}
