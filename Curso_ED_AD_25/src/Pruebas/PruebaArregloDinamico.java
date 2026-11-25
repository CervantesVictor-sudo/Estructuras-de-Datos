package Pruebas;

import EntradaSalida.Salida;
import edlineal.ArregloDinamico;

public class PruebaArregloDinamico {
    public static void main(String[] args) {
        ArregloDinamico arreglo = new ArregloDinamico();
        Salida.terminal("\n");

        arreglo.insertar("D");
        arreglo.insertar("G");
        arreglo.insertar("Z");

        arreglo.imprimir();
        Salida.terminal("\n\n");
        arreglo.insertarInicio("B");
        arreglo.insertarInicio("A");

        arreglo.imprimir();
        Salida.terminal("\n\n");


        Object datoEliminado = arreglo.eliminarInicio();
        Salida.terminal("Eliminando: " + datoEliminado + "\n\n");


        Salida.terminal("La lista ahorita tiene:\n");
        arreglo.imprimir();
        Salida.terminal("\n\n");
        Salida.terminal("Buscando X: " + arreglo.buscar("X")+"\n");
        Salida.terminal("Buscando G: " + arreglo.buscar("G")+"\n\n");


        arreglo.insertar("P");
        arreglo.insertar("W");
        arreglo.imprimir();
        Salida.terminal("\n\n");
        Salida.terminal("Eliminando al final: " + arreglo.eliminar() + "\n");
        arreglo.imprimir();
        Salida.terminal("\n\n");
        Salida.terminal("Eliminando al final: " + arreglo.eliminar("G") + "\n");
        arreglo.imprimir();
        Salida.terminal("\n\n");

    }
}
