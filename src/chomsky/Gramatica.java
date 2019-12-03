package chomsky;

import java.util.List;

/**
 *
 * @author marce
 */
public class Gramatica {

    private List<String> estados;
    private List<String> terminais;
    private List<Producao> producoes;
    private String start;

    public Gramatica(List<String> estados, List<String> terminais, List<Producao> producoes, String start) {
        this.estados = estados;
        this.terminais = terminais;
        this.producoes = producoes;
        this.start = start;
    }

    public List<String> getEstados() {
        return estados;
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

    public List<String> getTerminais() {
        return terminais;
    }

    public void setTerminais(List<String> terminais) {
        this.terminais = terminais;
    }

    public List<Producao> getProducoes() {
        return producoes;
    }

    public void setProducoes(List<Producao> producoes) {
        this.producoes = producoes;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void imprime() {
        Utilidades.imprime("Estados: ", estados);
        Utilidades.imprime("Terminais: ", terminais);
        System.out.println("Start: " + start);
        System.out.println("Producoes:");
        for (Producao producao : producoes) {
            producao.imprime();
        }
    }

    public void doidera() {
        System.out.println("Producoes:");
        for (Producao producao : producoes) {
            System.out.println(producao.getEstado() + " > ");
            for (Destino d : producao.getDestinos()) {
                d.imprime();
            }
        }
    }
}
