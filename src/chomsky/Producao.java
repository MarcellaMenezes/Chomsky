package chomsky;

import java.util.List;

/**
 *
 * @author marce
 */
public class Producao {

        private String estado;
        private List<Destino> destinos;

        public Producao(String estado, List<Destino> destinos) {
                this.estado = estado;
                this.destinos = destinos;
        }

        public String getEstado() {
                return estado;
        }

        public void setEstado(String estado) {
                this.estado = estado;
        }

        public List<Destino> getDestinos() {
                return destinos;
        }

        public void setDestinos(List<Destino> destinos) {
                this.destinos = destinos;
        }

        public void removeDestino(String estado) {
                destinos.removeIf((destino) -> {
                        if (destino.getConjuntoDestino().stream().anyMatch((parteDestino) -> (parteDestino.equals(estado)))) {
                                return true;
                        } // se contem o estado que deve ser removido, o destino é removido
                        return false; 
                });
        }

        public void imprime() {
                System.out.print(estado + " > ");
                for (Destino destino : destinos) {
                        destino.imprime();
                        System.out.print("\t");
                }
                System.out.println("");
        }
}
