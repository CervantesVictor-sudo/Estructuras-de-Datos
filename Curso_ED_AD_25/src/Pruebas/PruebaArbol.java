package Pruebas;

import EntradaSalida.Salida;
import ednolineal.ArbolBinario;

public class PruebaArbol {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        arbol.crearArbol();

        Salida.terminal("\n");
        Salida.terminal("Imprimiendo en Inorden: ");
        arbol.inorden();
        Salida.terminal("\n\n");

        Salida.terminal("Imprimiendo en Preorden: ");
        arbol.preorden();
        Salida.terminal("\n\n");

        Salida.terminal("Imprimiendo en Postorden: ");
        arbol.postorden();
        Salida.terminal("\n\n");
    }
}
