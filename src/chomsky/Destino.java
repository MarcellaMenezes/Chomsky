package chomsky;

import java.util.List;

/**
 *
 * @author marce
 */
public class Destino {

    private List<String> conjuntoDestino;

    public Destino(List<String> conjuntoDestino) {
        this.conjuntoDestino = conjuntoDestino;
    }

    public List<String> getConjuntoDestino() {
        return conjuntoDestino;
    }

    public void setConjuntoDestino(List<String> conjuntoDestino) {
        this.conjuntoDestino = conjuntoDestino;
    }

    public void imprime() {
        for (String valor : conjuntoDestino) {
            System.out.print(valor);
        }
    }

        @Override
        public String toString() {
                String returnStr = conjuntoDestino.toString();
                
                if (!conjuntoDestino.isEmpty())
                        returnStr = returnStr.substring(1, returnStr.length() -  1);
                
                return returnStr; 
        }
}