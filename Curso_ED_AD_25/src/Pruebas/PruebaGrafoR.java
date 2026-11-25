package Pruebas;

import EntradaSalida.Salida;
import ednolineal.Grafo;

public class PruebaGrafoR {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(8, 0.0);

        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("P");
        grafo.agregarVertice("T");
        grafo.agregarVertice("F");
        grafo.agregarVertice("M");
        grafo.agregarVertice("N");

        grafo.agregarArista("A", "B");
        grafo.agregarArista("A", "C");
        grafo.agregarArista("B", "P");
        grafo.agregarArista("B", "F");
        grafo.agregarArista("C", "F");
        grafo.agregarArista("P", "F");
        grafo.agregarArista("P", "M");
        grafo.agregarArista("T", "C");
        grafo.agregarArista("F", "T");
        grafo.agregarArista("M", "N");

        grafo.imprimirGrafo();
        Salida.terminal("\n");
        Salida.terminal("El recorrido del grafo es: \n");
        grafo.recorridoEnProfundidad("A").imprimir();
        Salida.terminal("\n\n");

    }
}
