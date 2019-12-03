package chomsky;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marce
 */
public class SimplificacaoGLC {

    //Eliminar produções inúteis
    //a) Nunca ser alcançada  
    public static boolean verificaSeEstado(String estado, List<String> estados) {
            return estados.contains(estado);
    }

    public static Producao producaoStart(Gramatica gramatica) {
        Producao producaoStart = null;
        for (Producao producao : gramatica.getProducoes()) {
            if (producao.getEstado().equals(gramatica.getStart())) {
                producaoStart = producao;
            }
        }
        return producaoStart;
    }

    public static List<String> estadosDaProducao(Producao p, Gramatica g) {
        List<String> estados = new ArrayList<>();
        for (Destino destino : p.getDestinos()) {
            for (String parteDestino : destino.getConjuntoDestino()) {
                if (verificaSeEstado(parteDestino, g.getEstados())) {
                    estados.add(parteDestino);
                }
            }
        }
        //Utilidades.imprime("Estados contidos no Start", estados);
        return estados;
    }

    public static List<String> estadosAlncancaveisDiretamente(Gramatica g) { // sao os estados contidos no Start
        Producao producaoStart = producaoStart(g);
       // return estadosDaProducao(producaoStart, g);
                //1º (S tem todo mundo? ok)
        List<String> estadosAlcancaveisDiretamente = new ArrayList<>();
        for (String estado : estadosDaProducao(producaoStart, g)) {
            for (Producao producao : g.getProducoes()) {
                if (estado.equals(producao.getEstado())) {
                    estadosAlcancaveisDiretamente.add(estado);
                }
            }
        }
        Utilidades.imprime("Estados Alcancaveis Diretamente: ", estadosAlcancaveisDiretamente);
        return estadosAlcancaveisDiretamente;

    }

    public static List<String> variaveisAlcancaveisIndiretamente(Gramatica gramatica) {
        List<String> estadosAlcancaveisIndiretamente = new ArrayList<>(); // tem q percorrer todas as producoes
        for (String estado : estadosAlncancaveisDiretamente(gramatica)) {
            for (Producao producao : gramatica.getProducoes()) {
                for (Destino destino : producao.getDestinos()) {
                    for (String estadoDoDestino : destino.getConjuntoDestino()) {
                        if (estadoDoDestino.equals(producao.getEstado())) {
                            if (verificaSeEstado(estado, estadosAlcancaveisIndiretamente) == false) { // se ainda n foi add
                                estadosAlcancaveisIndiretamente.add(estado);
                            }
                        }
                    }
                }
            }
        }
        //Utilidades.imprime("Estados Alcancaveis Idiretamente: ", estadosAlcancaveisIndiretamente);
        return estadosAlcancaveisIndiretamente;
    }

    public static boolean verificaSeTodosSaoAlcancaveis(Gramatica gramatica, List<String> estadosAlcancaveis) {
        if (estadosAlcancaveis.size() == gramatica.getProducoes().size()) {
            return true;
        }
        return false;
    }

    public static List<String> variaveisAlcancaveis(Gramatica gramatica) {
        List<String> estadosAlcancaveis;
        List<String> estadosAlcancaveisD = estadosAlncancaveisDiretamente(gramatica);
        List<String> estadosAlcancaveisI = variaveisAlcancaveisIndiretamente(gramatica);
        if (verificaSeTodosSaoAlcancaveis(gramatica, estadosAlcancaveisD)) {
            estadosAlcancaveis = estadosAlcancaveisD;
        } else {
            estadosAlcancaveis = estadosAlcancaveisI;
        }

        return estadosAlcancaveis;
    }

    public static List<String> variaveisInalcancaveis(Gramatica g) {
        List<String> estadosAlcancaveis = variaveisAlcancaveis(g);
        List<String> estadosInalcancaveis = new ArrayList<>();
        for (String estado : g.getEstados()) {
            if (!verificaSeEstado(estado, estadosAlcancaveis)) { // se o estado da gramatica não é um estado alcancavel
                estadosInalcancaveis.add(estado);
            }
        }
        //Utilidades.imprime("Estados inalcancaveis: ", estadosInalcancaveis);
        return estadosInalcancaveis;
    }

    public static void eliminarVariaveisInalcancaveis(Gramatica g) {
        List<String> estadosInalcancaveis = variaveisInalcancaveis(g);
        Utilidades.imprime("Estados inalcancaveis: ", estadosInalcancaveis);
        g.removeEstadosDaGramatica(estadosInalcancaveis);
    }
    
}
