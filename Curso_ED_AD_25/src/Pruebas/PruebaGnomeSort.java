package Pruebas;

import EntradaSalida.Salida;
import edlineal.ArregloEstatico;
import herramientas.Ordenamiento.GnomeSort;

public class PruebaGnomeSort {
    public static void main(String[] args) {
        ArregloEstatico arreglo = new ArregloEstatico(4);

        arreglo.insertar((int)5);
        arreglo.insertar((int)3);
        arreglo.insertar((int)2);
        arreglo.insertar((int)4);

        Salida.terminal("\n\nArreglo desordenado: \n");

        arreglo.imprimir();

        GnomeSort.gnomeSort(arreglo);

        Salida.terminal("\n\n");


        Salida.terminal("Arreglo acomodado: \n" );

        arreglo.imprimir();

        Salida.terminal("\n\n");
    }
}
