package Pruebas;

import EntradaSalida.Salida;
import edlineal.ArregloEstaticoOrd;

public class PruebaAEO {
    public static void main (String reprobados[]) {
        ArregloEstaticoOrd arreglo = new ArregloEstaticoOrd(6);

        arreglo.insertar("D");
        arreglo.insertar("M");
        arreglo.insertar("S");
        arreglo.insertar("A");
        arreglo.insertar("B");
        arreglo.insertar("C");

        arreglo.imprimir();
        Salida.terminal("\n");
    }
}
